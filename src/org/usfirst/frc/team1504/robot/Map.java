package org.usfirst.frc.team1504.robot;

public class Map {
/**
 * Utilities
 */
	public static final double UTIL_JOYSTICK_DEADZONE = 0.05;
	
	public static final int UTIL_OVERRIDE_BUTTON = 11;
	
/**
 * Inputs
 */
	public static final int DRIVE_CARTESIAN_JOYSTICK = 0;
	public static final int DRIVE_POLAR_JOYSTICK = 1;
	
	// Joystick inputs
	
/**
 * Drive class things
 */
	
	// Drive Motor enumeration
	public static enum DRIVE_MOTOR { FRONT_LEFT, BACK_LEFT, BACK_RIGHT, FRONT_RIGHT }
	
	// Drive Motor ports
	public static final int FRONT_LEFT_TALON_PORT = 10;
	public static final int BACK_LEFT_TALON_PORT = 11;
	public static final int BACK_RIGHT_TALON_PORT = 12;
	public static final int FRONT_RIGHT_TALON_PORT = 13;
	public static final int[] DRIVE_MOTOR_PORTS = {
			FRONT_LEFT_TALON_PORT,
			BACK_LEFT_TALON_PORT,
			BACK_RIGHT_TALON_PORT,
			FRONT_RIGHT_TALON_PORT
	};
	
	// Drive Input magic numbers
	public static final double[] DRIVE_INPUT_MAGIC_NUMBERS = { 1.0, 0.6 };
	public static final double DRIVE_INPUT_TURN_FACTOR = 0.2;
	public static final int DRIVE_INPUT_TURN_FACTOR_OVERRIDE_BUTTON = 1;
	
	// Drive Front Side changing
	public static final int DRIVE_FRONTSIDE_FRONT = 3;
	public static final int DRIVE_FRONTSIDE_BACK = 2;
	
	// Glide gain
	public static final double[][] DRIVE_GLIDE_GAIN = {{0.0015, 0.003}, {0.008, 0.008}};
	
	// Drive Output magic numbers - for getting everything spinning the correct direction
	public static final double[] DRIVE_OUTPUT_MAGIC_NUMBERS = { -1.0, -1.0, 1.0, 1.0 };	
	
	public static final int DRIVE_MAX_UNLOGGED_LOOPS = 15;
	
	
/**
 * Ground truth sensor
 */
	public static final byte GROUNDTRUTH_QUALITY_MINIMUM = 40;
	public static final double GROUNDTRUTH_DISTANCE_PER_COUNT = 1.0;
	public static final double GROUNDTRUTH_TURN_CIRCUMFERENCE = 3.1416 * 1.25;
	public static final int GROUNDTRUTH_SPEED_AVERAGING_SAMPLES = 4;
	
	// Maximum (empirically determined) speed the robot can go in its three directions. 
	public static final double[] GROUNDTRUTH_MAX_SPEEDS = {12.0, 5.0, 7.0};
	
	
/**
 * IO stuff
 */
	
	// Joystick raw axes
	public static final int JOYSTICK_Y_AXIS = 1;
	public static final int JOYSTICK_X_AXIS = 0;
	
/**
 * Vision Interface stuff
 */
	public static final int VISION_INTERFACE_OVERRIDE_BUTTON = 2;
	public static final double VISION_INTERFACE_VIDEO_WIDTH = 600; //800; //480; // FOV UPDATE
	public static final double VISION_INTERFACE_VIDEO_FOV = 50;//68;
	public static double VISION_INTERFACE_AIM_OFFSET = -7.5; // 0.85; // FOV UPDATE 
	public static final double VISION_INTERFACE_TURN_GAIN = 0.02;//0.1;
	public static final double VISION_INTERFACE_AIM_DEADZONE = 0.75; //1; //0.075;
	public static final double VISION_INTERFACE_TURN_MAX_OUTPUT = 0.15;
	public static final int VISION_INTERFACE_IMAGE_CAPTURE_SETTLE_TIMEOUT = 1750;
	
/**
 * Pneumatics stuff
 */
	public static final int PNEUMATICS_HIGHSIDE_PORT = 0;
	public static final int PNEUMATICS_LOWSIDE_PORT = 1;
	
/**
 * Logger stuff
 */
	public static enum LOGGED_CLASSES { SEMAPHORE, DRIVE, GROUNDTRUTH, PNEUMATICS }
	
	
public static final String TEAM_BANNER = "ICAgICAgICAgICBfX18gICAgICAgICAgICAgIF9fICBfXw0KICAgICAgICAgICAgfCBfIF8gIF8gICAgL3wgfF8gIC8gIFwgfF9ffA0KICAgICAgICAgICAgfCgtKF98fHx8ICAgIHwgX18pIFxfXy8gICAgfA0KDQogICAgICAgICAgICAgICAgICAgICAgICAgXy4NCiAgICAgICAgICAgICAgICAgICAgICAgLicgb28NCiAgICAgICAgICAgICAgICAgICAgICAgfCAgICA+DQogICAgICAgICAgICAgICAgICAgICAgLyAvIDogYC4NCiAgICAgICAgICAgICAgICAgICAgIHxfLyAvICAgfA0KICAgICAgICAgICAgICAgICAgICAgICB8LyAgd3cNCl9fXyAgICAgICAgX18gICAgICAgICAgICAgICAgICAgICAgX18NCiB8IHxfICBfICB8ICBcIF8gXyBfICBfIF8gXyB8XyBfICB8X18pXyBfICBfICAgIC4gXyAgXw0KIHwgfCApKC0gIHxfXy8oLV8pfF8pKC18IChffHxfKC0gIHwgICgtfCApKF8pfF98fHwgKV8pDQogICAgICAgICAgICAgICAgICB8ICAgICAgICAgICAgICAgICAgICAgICBfLw==";
public static final String ROBOT_BANNER = "ICAgICAvXCAgICAgL1wgICAgICAgICAgICAgICoNCiAgICAnLiBcICAgLyAsJyAgICAgICAgICAgICAgXCAgIH4NCiAgICAgIGAuXC0vLCcgICAgICAgICAgICAgXywsIFwge10NCiAgICAgICAoIFggICApICAgICAgICAgICAiLT1cO19cICUNCiAgICAgICwnLyBcYC5cICAgICAgICAgICAgXyBcXDsoIyklDQogICAgLicgLyAgIFwgYCwgICAgICAgICAgIF9cfCBcXyUlDQogICAgIFwvLS0tLS1cLycgICAgICAgICAgIFwgIFwvXCAgXA0KX19fX19fIHxfSF9fX3xfX19fX19fX19fX19fX18gKCApfn5+X19fXw0KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCBcDQogICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8gIC8=";
}
