package brut.androlib;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Hashtable;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class PostAnalysis 
{
	
	public static Hashtable<String, String> getDescriptions()
	{
		String data = "ACCEPT_HANDOVER\r\n" + 
				"Allows a calling app to continue a call which was started in another app.\r\n" + 
				"ACCESS_BACKGROUND_LOCATION\r\n" + 
				"Allows an app to access location in the background.\r\n" + 
				"ACCESS_CHECKIN_PROPERTIES\r\n" + 
				"Allows read/write access to the \"properties\" table in the checkin database, to change values that get uploaded.\r\n" + 
				"ACCESS_COARSE_LOCATION\r\n" + 
				"Allows an app to access approximate location.\r\n" + 
				"ACCESS_FINE_LOCATION\r\n" + 
				"Allows an app to access precise location.\r\n" + 
				"ACCESS_LOCATION_EXTRA_COMMANDS\r\n" + 
				"Allows an application to access extra location provider commands.\r\n" + 
				"ACCESS_MEDIA_LOCATION\r\n" + 
				"Allows an application to access any geographic locations persisted in the user's shared collection.\r\n" + 
				"ACCESS_NETWORK_STATE\r\n" + 
				"Allows applications to access information about networks.\r\n" + 
				"ACCESS_NOTIFICATION_POLICY\r\n" + 
				"Marker permission for applications that wish to access notification policy.\r\n" + 
				"ACCESS_WIFI_STATE\r\n" + 
				"Allows applications to access information about Wi-Fi networks.\r\n" + 
				"ACCOUNT_MANAGER\r\n" + 
				"Allows applications to call into AccountAuthenticators.\r\n" + 
				"ACTIVITY_RECOGNITION\r\n" + 
				"Allows an application to recognize physical activity.\r\n" + 
				"ADD_VOICEMAIL\r\n" + 
				"Allows an application to add voicemails into the system.\r\n" + 
				"ANSWER_PHONE_CALLS\r\n" + 
				"Allows the app to answer an incoming phone call.\r\n" + 
				"BATTERY_STATS\r\n" + 
				"Allows an application to collect battery statistics\r\n" + 
				"BIND_ACCESSIBILITY_SERVICE\r\n" + 
				"Must be required by an AccessibilityService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_APPWIDGET\r\n" + 
				"Allows an application to tell the AppWidget service which application can access AppWidget's data.\r\n" + 
				"BIND_AUTOFILL_SERVICE\r\n" + 
				"Must be required by a AutofillService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_CALL_REDIRECTION_SERVICE\r\n" + 
				"Must be required by a CallRedirectionService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_CARRIER_MESSAGING_CLIENT_SERVICE\r\n" + 
				"A subclass of CarrierMessagingClientService must be protected with this permission.\r\n" + 
				"BIND_CARRIER_MESSAGING_SERVICE\r\n" + 
				"This constant was deprecated in API level 23. Use BIND_CARRIER_SERVICES instead\r\n" + 
				"BIND_CARRIER_SERVICES\r\n" + 
				"The system process that is allowed to bind to services in carrier apps will have this permission.\r\n" + 
				"BIND_CHOOSER_TARGET_SERVICE\r\n" + 
				"This constant was deprecated in API level 30. For publishing direct share targets, please follow the instructions in https://developer.android.com/training/sharing/receive.html#providing-direct-share-targets instead.\r\n" + 
				"BIND_COMPANION_DEVICE_SERVICE\r\n" + 
				"Must be required by any CompanionDeviceServices to ensure that only the system can bind to it.\r\n" + 
				"BIND_CONDITION_PROVIDER_SERVICE\r\n" + 
				"Must be required by a ConditionProviderService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_CONTROLS\r\n" + 
				"Allows SystemUI to request third party controls.\r\n" + 
				"BIND_DEVICE_ADMIN\r\n" + 
				"Must be required by device administration receiver, to ensure that only the system can interact with it.\r\n" + 
				"BIND_DREAM_SERVICE\r\n" + 
				"Must be required by an DreamService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_INCALL_SERVICE\r\n" + 
				"Must be required by a InCallService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_INPUT_METHOD\r\n" + 
				"Must be required by an InputMethodService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_MIDI_DEVICE_SERVICE\r\n" + 
				"Must be required by an MidiDeviceService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_NFC_SERVICE\r\n" + 
				"Must be required by a HostApduService or OffHostApduService to ensure that only the system can bind to it.\r\n" + 
				"BIND_NOTIFICATION_LISTENER_SERVICE\r\n" + 
				"Must be required by an NotificationListenerService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_PRINT_SERVICE\r\n" + 
				"Must be required by a PrintService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_QUICK_ACCESS_WALLET_SERVICE\r\n" + 
				"Must be required by a QuickAccessWalletService to ensure that only the system can bind to it.\r\n" + 
				"BIND_QUICK_SETTINGS_TILE\r\n" + 
				"Allows an application to bind to third party quick settings tiles.\r\n" + 
				"BIND_REMOTEVIEWS\r\n" + 
				"Must be required by a RemoteViewsService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_SCREENING_SERVICE\r\n" + 
				"Must be required by a CallScreeningService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_TELECOM_CONNECTION_SERVICE\r\n" + 
				"Must be required by a ConnectionService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_TEXT_SERVICE\r\n" + 
				"Must be required by a TextService (e.g. SpellCheckerService) to ensure that only the system can bind to it.\r\n" + 
				"BIND_TV_INPUT\r\n" + 
				"Must be required by a TvInputService to ensure that only the system can bind to it.\r\n" + 
				"BIND_VISUAL_VOICEMAIL_SERVICE\r\n" + 
				"Must be required by a link VisualVoicemailService to ensure that only the system can bind to it.\r\n" + 
				"BIND_VOICE_INTERACTION\r\n" + 
				"Must be required by a VoiceInteractionService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_VPN_SERVICE\r\n" + 
				"Must be required by a VpnService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_VR_LISTENER_SERVICE\r\n" + 
				"Must be required by an VrListenerService, to ensure that only the system can bind to it.\r\n" + 
				"BIND_WALLPAPER\r\n" + 
				"Must be required by a WallpaperService, to ensure that only the system can bind to it.\r\n" + 
				"BLUETOOTH\r\n" + 
				"Allows applications to connect to paired bluetooth devices.\r\n" + 
				"BLUETOOTH_ADMIN\r\n" + 
				"Allows applications to discover and pair bluetooth devices.\r\n" + 
				"BLUETOOTH_CONNECT\r\n" + 
				"Required to be able to connect to paired Bluetooth devices.\r\n" + 
				"BLUETOOTH_PRIVILEGED\r\n" + 
				"Allows applications to pair bluetooth devices without user interaction, and to allow or disallow phonebook access or message access.\r\n" + 
				"BLUETOOTH_SCAN\r\n" + 
				"Required to be able to discover and pair nearby Bluetooth devices.\r\n" + 
				"BODY_SENSORS\r\n" + 
				"Allows an application to access data from sensors that the user uses to measure what is happening inside their body, such as heart rate.\r\n" + 
				"BROADCAST_PACKAGE_REMOVED\r\n" + 
				"Allows an application to broadcast a notification that an application package has been removed.\r\n" + 
				"BROADCAST_SMS\r\n" + 
				"Allows an application to broadcast an SMS receipt notification.\r\n" + 
				"BROADCAST_STICKY\r\n" + 
				"Allows an application to broadcast sticky intents.\r\n" + 
				"BROADCAST_WAP_PUSH\r\n" + 
				"Allows an application to broadcast a WAP PUSH receipt notification.\r\n" + 
				"CALL_COMPANION_APP\r\n" + 
				"Allows an app which implements the InCallService API to be eligible to be enabled as a calling companion app.\r\n" + 
				"CALL_PHONE\r\n" + 
				"Allows an application to initiate a phone call without going through the Dialer user interface for the user to confirm the call.\r\n" + 
				"CALL_PRIVILEGED\r\n" + 
				"Allows an application to call any phone number, including emergency numbers, without going through the Dialer user interface for the user to confirm the call being placed.\r\n" + 
				"CAMERA\r\n" + 
				"Required to be able to access the camera device.\r\n" + 
				"CAPTURE_AUDIO_OUTPUT\r\n" + 
				"Allows an application to capture audio output.\r\n" + 
				"CHANGE_COMPONENT_ENABLED_STATE\r\n" + 
				"Allows an application to change whether an application component (other than its own) is enabled or not.\r\n" + 
				"CHANGE_CONFIGURATION\r\n" + 
				"Allows an application to modify the current configuration, such as locale.\r\n" + 
				"CHANGE_NETWORK_STATE\r\n" + 
				"Allows applications to change network connectivity state.\r\n" + 
				"CHANGE_WIFI_MULTICAST_STATE\r\n" + 
				"Allows applications to enter Wi-Fi Multicast mode.\r\n" + 
				"CHANGE_WIFI_STATE\r\n" + 
				"Allows applications to change Wi-Fi connectivity state.\r\n" + 
				"CLEAR_APP_CACHE\r\n" + 
				"Allows an application to clear the caches of all installed applications on the device.\r\n" + 
				"CONTROL_LOCATION_UPDATES\r\n" + 
				"Allows enabling/disabling location update notifications from the radio.\r\n" + 
				"DELETE_CACHE_FILES\r\n" + 
				"Old permission for deleting an app's cache files, no longer used, but signals for us to quietly ignore calls instead of throwing an exception.\r\n" + 
				"DELETE_PACKAGES\r\n" + 
				"Allows an application to delete packages.\r\n" + 
				"DIAGNOSTIC\r\n" + 
				"Allows applications to RW to diagnostic resources.\r\n" + 
				"DISABLE_KEYGUARD\r\n" + 
				"Allows applications to disable the keyguard if it is not secure.\r\n" + 
				"DUMP\r\n" + 
				"Allows an application to retrieve state dump information from system services.\r\n" + 
				"EXPAND_STATUS_BAR\r\n" + 
				"Allows an application to expand or collapse the status bar.\r\n" + 
				"FACTORY_TEST\r\n" + 
				"Run as a manufacturer test application, running as the root user.\r\n" + 
				"FOREGROUND_SERVICE\r\n" + 
				"Allows a regular application to use Service.startForeground.\r\n" + 
				"GET_ACCOUNTS\r\n" + 
				"Allows access to the list of accounts in the Accounts Service.\r\n" + 
				"GET_ACCOUNTS_PRIVILEGED\r\n" + 
				"Allows access to the list of accounts in the Accounts Service.\r\n" + 
				"GET_PACKAGE_SIZE\r\n" + 
				"Allows an application to find out the space used by any package.\r\n" + 
				"GET_TASKS\r\n" + 
				"This constant was deprecated in API level 21. No longer enforced.\r\n" + 
				"GLOBAL_SEARCH\r\n" + 
				"This permission can be used on content providers to allow the global search system to access their data.\r\n" + 
				"HIDE_OVERLAY_WINDOWS\r\n" + 
				"Allows an app to prevent non-system-overlay windows from being drawn on top of it\r\n" + 
				"HIGH_SAMPLING_RATE_SENSORS\r\n" + 
				"Allows an app to access sensor data with a sampling rate greater than 200 Hz.\r\n" + 
				"INSTALL_LOCATION_PROVIDER\r\n" + 
				"Allows an application to install a location provider into the Location Manager.\r\n" + 
				"INSTALL_PACKAGES\r\n" + 
				"Allows an application to install packages.\r\n" + 
				"INSTALL_SHORTCUT\r\n" + 
				"Allows an application to install a shortcut in Launcher.\r\n" + 
				"INSTANT_APP_FOREGROUND_SERVICE\r\n" + 
				"Allows an instant app to create foreground services.\r\n" + 
				"INTERACT_ACROSS_PROFILES\r\n" + 
				"Allows interaction across profiles in the same profile group.\r\n" + 
				"INTERNET\r\n" + 
				"Allows applications to open network sockets.\r\n" + 
				"KILL_BACKGROUND_PROCESSES\r\n" + 
				"Allows an application to call ActivityManager.killBackgroundProcesses().\r\n" + 
				"LOADER_USAGE_STATS\r\n" + 
				"Allows a data loader to read a package's access logs.\r\n" + 
				"LOCATION_HARDWARE\r\n" + 
				"Allows an application to use location features in hardware, such as the geofencing api.\r\n" + 
				"MANAGE_DOCUMENTS\r\n" + 
				"Allows an application to manage access to documents, usually as part of a document picker.\r\n" + 
				"MANAGE_EXTERNAL_STORAGE\r\n" + 
				"Allows an application a broad access to external storage in scoped storage.\r\n" + 
				"MANAGE_MEDIA\r\n" + 
				"Allows an application to modify and delete media files on this device or any connected storage device without user confirmation.\r\n" + 
				"MANAGE_ONGOING_CALLS\r\n" + 
				"Allows to query ongoing call details and manage ongoing calls\r\n" + 
				"MANAGE_OWN_CALLS\r\n" + 
				"Allows a calling application which manages its own calls through the self-managed ConnectionService APIs.\r\n" + 
				"MASTER_CLEAR\r\n" + 
				"Not for use by third-party applications.\r\n" + 
				"MEDIA_CONTENT_CONTROL\r\n" + 
				"Allows an application to know what content is playing and control its playback.\r\n" + 
				"MODIFY_AUDIO_SETTINGS\r\n" + 
				"Allows an application to modify global audio settings.\r\n" + 
				"MODIFY_PHONE_STATE\r\n" + 
				"Allows modification of the telephony state - power on, mmi, etc.\r\n" + 
				"MOUNT_FORMAT_FILESYSTEMS\r\n" + 
				"Allows formatting file systems for removable storage.\r\n" + 
				"MOUNT_UNMOUNT_FILESYSTEMS\r\n" + 
				"Allows mounting and unmounting file systems for removable storage.\r\n" + 
				"NFC\r\n" + 
				"Allows applications to perform I/O operations over NFC.\r\n" + 
				"NFC_PREFERRED_PAYMENT_INFO\r\n" + 
				"Allows applications to receive NFC preferred payment service information.\r\n" + 
				"NFC_TRANSACTION_EVENT\r\n" + 
				"Allows applications to receive NFC transaction events.\r\n" + 
				"PACKAGE_USAGE_STATS\r\n" + 
				"Allows an application to collect component usage statistics. Declaring the permission implies intention to use the API and the user of the device can grant permission through the Settings application.\r\n" + 
				"PERSISTENT_ACTIVITY\r\n" + 
				"This constant was deprecated in API level 15. This functionality will be removed in the future; please do not use. Allow an application to make its activities persistent.\r\n" + 
				"PROCESS_OUTGOING_CALLS\r\n" + 
				"This constant was deprecated in API level 29. Applications should use CallRedirectionService instead of the Intent.ACTION_NEW_OUTGOING_CALL broadcast.\r\n" + 
				"QUERY_ALL_PACKAGES\r\n" + 
				"Allows query of any normal app on the device, regardless of manifest declarations.\r\n" + 
				"READ_CALENDAR\r\n" + 
				"Allows an application to read the user's calendar data.\r\n" + 
				"READ_CALL_LOG\r\n" + 
				"Allows an application to read the user's call log.\r\n" + 
				"READ_CONTACTS\r\n" + 
				"Allows an application to read the user's contacts data.\r\n" + 
				"READ_EXTERNAL_STORAGE\r\n" + 
				"Allows an application to read from external storage.\r\n" + 
				"READ_INPUT_STATE\r\n" + 
				"This constant was deprecated in API level 16. The API that used this permission has been removed.\r\n" + 
				"READ_LOGS\r\n" + 
				"Allows an application to read the low-level system log files.\r\n" + 
				"READ_PHONE_NUMBERS\r\n" + 
				"Allows read access to the device's phone number(s).\r\n" + 
				"READ_PHONE_STATE\r\n" + 
				"Allows read only access to phone state, including the current cellular network information, the status of any ongoing calls, and a list of any PhoneAccounts registered on the device.\r\n" + 
				"READ_PRECISE_PHONE_STATE\r\n" + 
				"Allows read only access to precise phone state.\r\n" + 
				"READ_SMS\r\n" + 
				"Allows an application to read SMS messages.\r\n" + 
				"READ_SYNC_SETTINGS\r\n" + 
				"Allows applications to read the sync settings.\r\n" + 
				"READ_SYNC_STATS\r\n" + 
				"Allows applications to read the sync stats.\r\n" + 
				"READ_VOICEMAIL\r\n" + 
				"Allows an application to read voicemails in the system.\r\n" + 
				"REBOOT\r\n" + 
				"Required to be able to reboot the device.\r\n" + 
				"RECEIVE_BOOT_COMPLETED\r\n" + 
				"Allows an application to receive the Intent.ACTION_BOOT_COMPLETED that is broadcast after the system finishes booting.\r\n" + 
				"RECEIVE_MMS\r\n" + 
				"Allows an application to monitor incoming MMS messages.\r\n" + 
				"RECEIVE_SMS\r\n" + 
				"Allows an application to receive SMS messages.\r\n" + 
				"RECEIVE_WAP_PUSH\r\n" + 
				"Allows an application to receive WAP push messages.\r\n" + 
				"RECORD_AUDIO\r\n" + 
				"Allows an application to record audio.\r\n" + 
				"REORDER_TASKS\r\n" + 
				"Allows an application to change the Z-order of tasks.\r\n" + 
				"REQUEST_COMPANION_PROFILE_WATCH\r\n" + 
				"Allows app to request to be associated with a device via CompanionDeviceManager as a \"watch\"\r\n" + 
				"REQUEST_COMPANION_RUN_IN_BACKGROUND\r\n" + 
				"Allows a companion app to run in the background.\r\n" + 
				"REQUEST_COMPANION_USE_DATA_IN_BACKGROUND\r\n" + 
				"Allows a companion app to use data in the background.\r\n" + 
				"REQUEST_DELETE_PACKAGES\r\n" + 
				"Allows an application to request deleting packages.\r\n" + 
				"REQUEST_IGNORE_BATTERY_OPTIMIZATIONS\r\n" + 
				"Permission an application must hold in order to use Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS.\r\n" + 
				"REQUEST_INSTALL_PACKAGES\r\n" + 
				"Allows an application to request installing packages.\r\n" + 
				"REQUEST_OBSERVE_COMPANION_DEVICE_PRESENCE\r\n" + 
				"Allows an application to subscribe to notifications about the presence status change of their associated companion device\r\n" + 
				"REQUEST_PASSWORD_COMPLEXITY\r\n" + 
				"Allows an application to request the screen lock complexity and prompt users to update the screen lock to a certain complexity level.\r\n" + 
				"RESTART_PACKAGES\r\n" + 
				"This constant was deprecated in API level 15. The ActivityManager.restartPackage() API is no longer supported.\r\n" + 
				"SCHEDULE_EXACT_ALARM\r\n" + 
				"Allows an app to use exact alarm scheduling APIs to perform timing sensitive background work.\r\n" + 
				"SEND_RESPOND_VIA_MESSAGE\r\n" + 
				"Allows an application (Phone) to send a request to other applications to handle the respond-via-message action during incoming calls.\r\n" + 
				"SEND_SMS\r\n" + 
				"Allows an application to send SMS messages.\r\n" + 
				"SET_ALARM\r\n" + 
				"Allows an application to broadcast an Intent to set an alarm for the user.\r\n" + 
				"SET_ALWAYS_FINISH\r\n" + 
				"Allows an application to control whether activities are immediately finished when put in the background.\r\n" + 
				"SET_ANIMATION_SCALE\r\n" + 
				"Modify the global animation scaling factor.\r\n" + 
				"SET_DEBUG_APP\r\n" + 
				"Configure an application for debugging.\r\n" + 
				"SET_PREFERRED_APPLICATIONS\r\n" + 
				"This constant was deprecated in API level 15. No longer useful, see PackageManager.addPackageToPreferred() for details.\r\n" + 
				"SET_PROCESS_LIMIT\r\n" + 
				"Allows an application to set the maximum number of (not needed) application processes that can be running.\r\n" + 
				"SET_TIME\r\n" + 
				"Allows applications to set the system time directly.\r\n" + 
				"SET_TIME_ZONE\r\n" + 
				"Allows applications to set the system time zone directly.\r\n" + 
				"SET_WALLPAPER\r\n" + 
				"Allows applications to set the wallpaper.\r\n" + 
				"SET_WALLPAPER_HINTS\r\n" + 
				"Allows applications to set the wallpaper hints.\r\n" + 
				"SIGNAL_PERSISTENT_PROCESSES\r\n" + 
				"Allow an application to request that a signal be sent to all persistent processes.\r\n" + 
				"SMS_FINANCIAL_TRANSACTIONS\r\n" + 
				"This constant was deprecated in API level S. The API that used this permission is no longer functional.\r\n" + 
				"START_FOREGROUND_SERVICES_FROM_BACKGROUND\r\n" + 
				"Allows an application to start foreground services from background, can only be granted to privileged apps or app that is SMS/EMERGENCY/SYSTEM GALLERY roles.\r\n" + 
				"START_VIEW_PERMISSION_USAGE\r\n" + 
				"Allows the holder to start the permission usage screen for an app.\r\n" + 
				"STATUS_BAR\r\n" + 
				"Allows an application to open, close, or disable the status bar and its icons.\r\n" + 
				"SYSTEM_ALERT_WINDOW\r\n" + 
				"Allows an app to create windows using the type WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, shown on top of all other apps.\r\n" + 
				"TRANSMIT_IR\r\n" + 
				"Allows using the device's IR transmitter, if available.\r\n" + 
				"UNINSTALL_SHORTCUT\r\n" + 
				"Don't use this permission in your app.\r\n" + 
				"UPDATE_DEVICE_STATS\r\n" + 
				"Allows an application to update device statistics.\r\n" + 
				"USE_BIOMETRIC\r\n" + 
				"Allows an app to use device supported biometric modalities.\r\n" + 
				"USE_FINGERPRINT\r\n" + 
				"This constant was deprecated in API level 28. Applications should request USE_BIOMETRIC instead\r\n" + 
				"USE_FULL_SCREEN_INTENT\r\n" + 
				"Required for apps targeting Build.VERSION_CODES.Q that want to use notification full screen intents.\r\n" + 
				"USE_ICC_AUTH_WITH_DEVICE_IDENTIFIER\r\n" + 
				"Allows to read device identifiers and use ICC based authentication like EAP-AKA.\r\n" + 
				"USE_SIP\r\n" + 
				"Allows an application to use SIP service.\r\n" + 
				"VIBRATE\r\n" + 
				"Allows access to the vibrator.\r\n" + 
				"WAKE_LOCK\r\n" + 
				"Allows using PowerManager WakeLocks to keep processor from sleeping or screen from dimming.\r\n" + 
				"WRITE_APN_SETTINGS\r\n" + 
				"Allows applications to write the apn settings and read sensitive fields of an existing apn settings like user and password.\r\n" + 
				"WRITE_CALENDAR\r\n" + 
				"Allows an application to write the user's calendar data.\r\n" + 
				"WRITE_CALL_LOG\r\n" + 
				"Allows an application to write (but not read) the user's call log data.\r\n" + 
				"WRITE_CONTACTS\r\n" + 
				"Allows an application to write the user's contacts data.\r\n" + 
				"WRITE_EXTERNAL_STORAGE\r\n" + 
				"Allows an application to write to external storage.\r\n" + 
				"WRITE_GSERVICES\r\n" + 
				"Allows an application to modify the Google service map.\r\n" + 
				"WRITE_SECURE_SETTINGS\r\n" + 
				"Allows an application to read or write the secure system settings.\r\n" + 
				"WRITE_SETTINGS\r\n" + 
				"Allows an application to read or write the system settings.\r\n" + 
				"WRITE_SYNC_SETTINGS\r\n" + 
				"Allows applications to write the sync settings.\r\n" + 
				"WRITE_VOICEMAIL\r\n" + 
				"Allows an application to modify and remove existing voicemails in the system.\r\n" + 
				"";
		
				Hashtable<String, String> table = new Hashtable();
				BufferedReader bufReader = new BufferedReader(new StringReader(data));
				
				String permission;
				try 
				{
					permission = bufReader.readLine();
					
					while (permission != null)
					{
						String desc = bufReader.readLine();
						
						if (desc != null)
						{
							table.put("android.permission." + permission, desc);
						}
						else
						{
							break;
						}

						permission = bufReader.readLine();
					}
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				return table;
	}
	
	public static void writePermissions (String filePath) // List the android permissions of a target AndroidManifest.XML
	{
		try
		{
			// Read AndroidManifest.xml
			File manifest = new File(filePath + "\\AndroidManifest.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(manifest);
			
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xpath = xPathFactory.newXPath();
			
			XPathExpression expr = xpath.compile("//uses-permission");
			
			NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			
			// Write to new txt file based off xml file
			
			File folder = new File(filePath + "\\Analysis");
			folder.mkdir();
			
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("Permissions");
			
			Row header = sheet.createRow(0);
			
			CellStyle headerStyle = wb.createCellStyle();
			
			Font headerFont = wb.createFont();
			headerFont.setFontName("Calibri");
			headerFont.setFontHeightInPoints((short) 11);
			headerFont.setBold(true);
			headerStyle.setFont(headerFont);
			
			CellStyle bodyStyle = wb.createCellStyle();
			Font bodyFont = wb.createFont();
			bodyFont.setFontName("Calibri");
			bodyFont.setFontHeightInPoints((short) 11);
			bodyStyle.setFont(bodyFont);
			
			Cell headerCell = header.createCell(0);
			headerCell.setCellValue("Permission");
			headerCell.setCellStyle(headerStyle);
			
			headerCell = header.createCell(1);
			headerCell.setCellValue("Description (if available)");
			headerCell.setCellStyle(headerStyle);
			
			Hashtable<String, String> descTable = getDescriptions();
			
			for (int i = 0; i < nl.getLength(); ++i)
			{
				Node currentItem = nl.item(i);
				
				Row curr = sheet.createRow(i + 1); // Create a new row for every permission; start from 1 since 0 is the header row
				
				Cell nameCell = curr.createCell(0);
				String permissionName = currentItem.getAttributes().getNamedItem("android:name").getNodeValue();
				nameCell.setCellValue(permissionName);
				nameCell.setCellStyle(bodyStyle);
				
				Cell descCell = curr.createCell(1);
				String desc = descTable.get(permissionName);
				descCell.setCellValue(desc);
				descCell.setCellStyle(bodyStyle);
			}
			
			
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			
			String fileLocation = filePath + "\\Analysis\\Permissions.xlsx";
			
			FileOutputStream outputStream = new FileOutputStream(fileLocation);
			wb.write(outputStream);
			wb.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
	}

}
