Ask for permission
`<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />`
```kotlin
private fun askForPermission() {
 val pState = ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)


 if (pState == PackageManager.PERMISSION_DENIED) {
   ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS) ,1)
 }
}
```

Create Notif Channel
```kotlin
private fun createNotificationChannel() {
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
   val importance = NotificationManager.IMPORTANCE_DEFAULT
   val channel = NotificationChannel("channelId", "channelName", importance).apply {
     description = "Default Channel Description"
     enableLights(true)
     lightColor = Color.RED
   }

   // Register the channel with the system
   val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
   notificationManager.createNotificationChannel(channel)
 }
}
```

Then create notif

```kotlin
val notification = NotificationCompat.Builder(context, "channelId")
 .setContentTitle(response.body()!!.date)
 .setContentText("This is the notification message.")
 .setSmallIcon(androidx.core.R.drawable.notification_action_background)
 .setPriority(NotificationCompat.PRIORITY_DEFAULT)
 .build()

// Show notification
val notificationManager = NotificationManagerCompat.from(context)

try {
 notificationManager.notify(100, notification)
} catch (_: SecurityException) {

}
```