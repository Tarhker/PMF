
import gnu.io.*;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modele.*;

public class CAD
{
    Modele monModele;
    public CAD(Modele monModele, String port) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException
    {
        super();
        this.monModele = monModele;
        this.connect(port);
        }
        
    
    public void connect( String portName ) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: Port is currently in use");
        }
        else
        {
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            
            if ( commPort instanceof SerialPort )
            {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
                
                (new Thread(new SerialReader(in))).start();
                (new Thread(new SerialWriter(out))).start();

            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }
    
    /** */
    public  class SerialReader implements Runnable 
    {
        InputStream in;
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void run ()
        {
            byte[] buffer = new byte[1024];
            int len = -1;
            String message = "";
            try
            {
                while ( ( len = this.in.read(buffer)) > -1 )
                {
                    message =  new String(buffer,0,len);
                    Thread.sleep(1000);
                   
                    String[] tokens = message.split(";");
                    for(int i = 0; i<tokens.length;i++)
                    {
                        switch(i){
                            case 0: 
                            	break;
                            case 1: 
                                double humidite = Double.parseDouble(tokens[i]);
                                monModele.setHumidite(humidite);
                                break;
                            case 2:
                                double temperature = Double.parseDouble(tokens[i]);
                                monModele.setTempActuelle(temperature);
                                break;
                            default:
                                break; 
                        }
                    }
                    
                    
                    
                }
                
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(CAD.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

    /** */
    public static class SerialWriter implements Runnable 
    {
        OutputStream out;
        
        public SerialWriter ( OutputStream out )
        {
            this.out = out;
        }
        
        public void run ()
        {
            try
            {                
                int c = 0;
                while ( ( c = System.in.read()) > -1 )
                {
                    this.out.write(c);
                }                
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }            
        }
    }
    

}