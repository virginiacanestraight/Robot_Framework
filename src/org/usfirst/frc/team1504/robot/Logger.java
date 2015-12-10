package org.usfirst.frc.team1504.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.usfirst.frc.team1504.robot.Update_Semaphore.Log_Updatable;

//import edu.wpi.first.wpilibj.BuiltInAccelerometer;
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
//import edu.wpi.first.wpilibj.Timer;

public class Logger implements Log_Updatable {
	
	/*private Compressor _compressor = new Compressor();
	private BuiltInAccelerometer _accelerometer = new BuiltInAccelerometer();
	private PowerDistributionPanel _pdp = new PowerDistributionPanel();
	private DriverStation _ds = DriverStation.getInstance();*/
	
	private File _outfile;
	private FileOutputStream _file_output;
	
	private long _start_time;
	private volatile byte[][] _logged_data = null;
	private volatile boolean _logging = false;
	
	//private Drive _drive = Drive.getInstance();
	
	private static final Logger instance = new Logger();
	
	protected Logger()
	{
		
	}
	
	public static Logger getInstance()
	{
		return instance;
	}
	
	/**
	 * Start the logger
	 * @param prefix - The filename prefix to log under (Format: Prefix-Time.log)
	 */
	public void start(String prefix) {
		Calendar cal = new GregorianCalendar();
		String filetime = Long.toString(cal.getTimeInMillis());
		_outfile = new File("/home/lvuser/log/" + prefix + "-" + filetime + ".log");

		try {
			_file_output = new FileOutputStream(_outfile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not open logging file.\n" + _outfile);
			e.printStackTrace();
		}

		_start_time = System.currentTimeMillis();
	}
	
	/**
	 * Stop the logger
	 */
	public void stop()
	{
		if (_file_output == null) {
			System.out.println("disable called on null");
		} else {
			try {
				_file_output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Flush data to disk. Synchronize to prevent data being added in the middle of a file write.
	 */
	private void sync_flush()
	{
		_logging = true;
		flush_data();
		_logging = false;
	}
	
	/**
	 * Flush current data buffer to disk.
	 */
	private void flush_data()
	{
		if(_file_output == null)
			return;
		
		byte[][] data_buffer = _logged_data;
		
		// Format: "^" literal (1) / Time (8) / Logged Classes (1) / Class data (#)
		try {
			_file_output.write(94); // ^
			byte[] time = new byte[8];
			ByteBuffer.wrap(time).putLong(System.currentTimeMillis() - _start_time);
			_file_output.write(time);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		for(byte[] o : data_buffer)
		{
			if(o != null)
			{
				try {
					_file_output.write(o);
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}
	
	/**
	 * Log data from logging classes to disk.
	 * @param logging_class - What class is currently logging
	 * @param data - The data to be logged
	 */
	public boolean log(Map.LOGGED_CLASSES logging_class, byte[] data)
	{
		if(logging_class == Map.LOGGED_CLASSES.SEMAPHORE)
		{
			if(_logged_data != null)
				sync_flush();
			
			_logged_data = new byte[Map.LOGGED_CLASSES.values().length][];
			_logged_data[0] = new byte[]{0};
		}
		else if(_logging)
		{
			return false;
		}
		
		_logged_data[0][0] = (byte) (_logged_data[0][0] | 1 << logging_class.ordinal());
		_logged_data[logging_class.ordinal() + 1] = data;
		
		return true;
	}
}
