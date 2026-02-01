# ScrollPause
ScrollPause helps users become aware of their scrolling habits without shaming or force. When a time limit is crossed it gently intervenes with a calm pop-up and a short, non-stimulating game to break the scroll loop. Users then reflect on their tasks and choose whether to continue scrolling or focus,with a short lock creating space for reflection.

Description:

ScrollPause works on behavioral psychology by interrupting unconscious scrolling habits and restoring user awareness. Through gentle, non-stimulating intervention and choice-based reflection, it reduces impulsive behavior and encourages mindful, self-regulated screen use. When a user crosses a set scrolling time limit on Reels or Shorts, the app gently intervenes with a calm pop-up instead of an aggressive block. It first engages the user in a short, non-stimulating activity (two rounds of tic-tac-toe) to break the automatic scrolling loop.
After that, the app asks the user to reflect by entering a couple of tasks they actually want or need to do.  Then The user is given a choice—continue scrolling or continue with their tasks—so they remain in control of their decisions.
If the user chooses to focus on tasks, the scrolling apps are temporarily locked for a short period (10–15 minutes), creating a safe space for self-reflection and productivity

How its different from other Blocking apps:

Most existing solutions either completely block apps or bombard users with strict warnings, which often feels frustrating and causes people to uninstall them. The real problem isn’t lack of discipline—it’s the absence of mindful interruption at the right moment.

Scope and Limitations:

Since pop-up overlays are restricted on YouTube, ScrollPause currently uses system notifications as a substitute for pop-ups to trigger mindful intervention. For demo purposes, the scrolling time limit is set to 10 seconds to quickly showcase the complete flow. The app has been developed and tested using the Android Emulator, with further optimization planned for real devices.

Future Enhancements:

We plan to publish ScrollPause on the real devices and detection of rrls and shorts in real time , request the necessary permissions to enable full pop-up overlays and deeper system integration. Additional improvements will include configurable time limits, enhanced UI polish, and broader testing on physical devices to ensure a smoother and more reliable user experience.
 
Tech Stack:

The app is developed using Java in Android Studio. It utilizes core Android components such as Activities, Services, Foreground Services, Broadcast Receivers, and Notifications. The app leverages the UsageStatsManager API for app usage tracking, SharedPreferences for storing tasks, and Handler/Looper for timed operations.
All UI layouts are built using XML, ensuring a calm and responsive interface. The app targets Android API level 33+ and supports runtime permissions for Android 13 and above.
 
Features:

>Timed scroll monitoring with a notification trigger after a set duration (10–20 seconds for demo purposes)
>Gentle intervention using a non-stimulating Tic Tac Toe mini-game
>Task input prompt to encourage mindful planning after gameplay
>User choice between continuing scrolling or focusing on entered tasks
>Limited rounds of interaction to prevent over-engagement
>Friendly reminders promoting task completion and self-reflection
>Foreground service for continuous monitoring even when the app runs in the background
>Calm, minimal UI design aligned with reducing digital overstimulation


deployment:

The app can be deployed as a standalone APK using Android Studio. Since it relies on foreground services and notifications instead of overlay popups, it does not require special system overlay permissions. After building the project via Build → Rebuild Project, the APK can be signed and installed on devices running Android API 26+.
Runtime permissions for notifications and usage access are requested on first launch. The app can be distributed via side-loading for demo purposes and is fully compatible with both physical Android devices and emulators.
