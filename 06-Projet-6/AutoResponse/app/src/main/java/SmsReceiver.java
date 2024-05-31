public class SmsReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    Bundle bundle = intent.getExtras();
    if (bundle != null) {
      Object[] pdus = (Object[]) bundle.get("pdus");
      if (pdus != null) {
        for (Object pdu : pdus) {
          SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
          String sender = smsMessage.getDisplayOriginatingAddress();
          String messageBody = smsMessage.getMessageBody();

          // Code to check if auto-response is enabled for the sender and send response
          if (isAutoResponseEnabled(context, sender)) {
            sendAutoResponse(context, sender);
          }
        }
      }
    }
  }
}

public class SmsScheduler {
  public static void scheduleSms(Context context, long timeInMillis, String phoneNumber, String message) {
    Intent intent = new Intent(context, SmsSender.class);
    intent.putExtra("phoneNumber", phoneNumber);
    intent.putExtra("message", message);

    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent);
  }
}

public class SmsSender extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    String phoneNumber = intent.getStringExtra("phoneNumber");
    String message = intent.getStringExtra("message");

    SmsManager smsManager = SmsManager.getDefault();
    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
  }
}
