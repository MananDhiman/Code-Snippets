<img src="https://github.com/MananDhiman/Code-Snippets/assets/64782929/cf722766-0853-456f-a9c6-8ac449711ed2" width="500" alt="android activity lifecycle diagram">

**Nonexistent** represents an activity that has not been launched yet or an activity that was just destroyed (by pressing the Back button). sometimes referred to as the **“destroyed”** state. There is no instance in memory, and there is no associated view.

**Stopped** represents an activity that has an instance in memory but whose view is not visible on the screen. Occurs when the activity is first spinning up and re-occurs any time the view is fully occluded (such as when the user launches another full-screen activity, presses the Home button, or uses the overview screen to switch tasks).

**Paused** represents an activity that is not active in the foreground but whose view is visible or partially visible. Partially visible, for example, if the user launched a new dialog-themed or transparent activity on top of it. Also be fully visible but not in the foreground if the user is viewing two activities in multi-window mode (also called “split-screen mode”).

**Resumed** represents an activity that is in memory, fully visible, and in the foreground. It is the activity the user is currently interacting with. Only one activity across the entire system can be in the resumed state at any given time. That means that if one activity is moving into the resumed state, another is likely moving out of the resumed state.

It is important to understand that you never call onCreate(Bundle?) or any of the other Activity lifecycle functions yourself. You simply override the callbacks in your activity subclass. Then Android calls the lifecycle callbacks at the appropriate time

# Rotation

Rotating the device changes the device configuration. The device configuration is a set of characteristics that describe the current state of an individual device. The characteristics that make up the configuration include screen orientation, screen density, screen size, keyboard type, dock mode, language, and more.

When a runtime configuration change occurs, there may be resources that are a better match for the new configuration. So Android destroys the activity, looks for resources that are the best fit for the new configuration, and then rebuilds a new instance of the activity with those resources.
