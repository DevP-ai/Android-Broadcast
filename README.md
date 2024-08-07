# Android-Broadcast

## Broadcast Receiver
 1. Broadcast in android is the system-wide events that can occur when the device starts, when a message is received on the device or when incoming calls are received,or when device goes to aiplane modes, etc.
 
 2. Broadcast Receivers are used to respond to these system-wide events.

 3. Broadcast receivers allow us to register for the system and application events, and when that event happens, then the register receivers get notified.

 4. Broadcast can be sent globally ot locally abd can be received by any registered app.

 <b>There are mainly two types of Broadcast Receivers:</b>

   <b>Static Broadcast Receivers: </b>These types of receivers are declared in the manifest file and works even if the app is closed.

   <b>Dynamic Broadcast Receivers: </b>These types of receivers work only if the app is active or minimized.

## Intent Filters

 1. In Android development, intent filters are used to specify which intents an activity, service, or broadcast receiver is willing to receive. In addition to actions, intent filters can use categories to provide more precise matching of intents.

 2. Categories are used to declare additional information about the kind of component that should handle the intent. 

 3. When an intent is sent with a specific action and category, the system will only match it to components that have declared the same action and category in their intent filter.

 4. By using categories in addition to actions, you can ensure that your component only receives intents that are relevant to its functionality.
 

## Common System Broadcasts

<b>1.Battery Low:</b> Sent when the device's battery level drops below a certain threshold, allowing apps to conserve power or notify the user.

<b>2.Screen On/Off:</b> Sent when the device's screen is turned on or off, allowing apps to adjust their behavior or save resources.

<b>3.Device Boot:</b> Sent when the device finishes booting up, allowing apps to start up services or perform initialization tasks.

<b>4.Network Connectivity Changes:</b> Sent when the device's network connectivity changes, allowing apps to respond to changes in network status or availability.

<b>5.Timezone Changes:</b> Sent when the device's timezone changes, allowing apps to adjust their behavior or update time-sensitive information.

## Types of Broadcast:

### 1.Custom Broadcasts: 
Custom Broadcasts are app-specific messages that can be defined using a unique action string, sent using the sendBroadcast() method, and handled by a Broadcast Receiver to perform app-specific tasks.
   
### 2.Local Broadcasts:
Local Broadcasts are used by an app to communicate with its own components, such as Activities, Services, and Broadcast Receivers, within the same process. These broadcasts are not sent outside of the app and are not visible to other apps or users. To send a Local Broadcast, an app creates an Intent object with a custom action string and any extra data it wants to include. The LocalBroadcastManager class is then used to send the Intent to all registered Broadcast Receivers within the same app's process. Local Broadcasts are useful for intra-app communication without exposing data to other apps or users.

LocalBroadcastManager is a lightweight alternative to using Intents to communicate between components in your app. It has several benefits over using Intents, including improved performance and security. Since LocalBroadcastManager only broadcasts to components within your app, it is more efficient than using a global broadcast. Additionally, since broadcasts are not sent outside of your app, there is no risk of sensitive data being leaked. Finally, LocalBroadcastManager is easier to use than Intents, since you don't need to worry about creating Intents and handling Intent filters.

### 3.Ordered Broadcasts:
Ordered Broadcasts are a type of Android broadcast that are processed in a specific order. They are sent to one receiver at a time, and the order in which they are received is determined by the priority of the receiver. The priority is set in the AndroidManifest.xml file, and the default priority is 0. Ordered Broadcasts can be used to ensure that a specific receiver processes a broadcast before any other receivers. This can be useful for situations where one receiver needs to perform a certain action before another receiver can proceed.

## Comparison with Other Messaging Mechanisms
### 1.Intents:

Intents are a flexible way to start activities, services, or broadcast receivers, and can also be used to pass data between components. They are useful when you need to start a new component or pass data between components that are not directly connected. However, they can be relatively slow, especially when passing large amounts of data.

### 2.Handlers:

Handlers are used to send and process messages between threads. They are useful when you need to perform background tasks and update the UI on the main thread. Handlers can be more efficient than Intents because they don't require serialization, but they can be more difficult to use because you need to manage the thread and message queue.

### 3.LocalBroadcastManager:

LocalBroadcastManager is a lightweight alternative to using Intents to communicate between components within your app. It has several benefits over using Intents, including improved performance and security. Since LocalBroadcastManager only broadcasts to components within your app, it is more efficient than using a global broadcast. Additionally, since broadcasts are not sent outside of your app, there is no risk of sensitive data being leaked. Finally, LocalBroadcastManager is easier to use than Intents, since you don't need to worry about creating Intents and handling Intent filters.

### 4.EventBus:

EventBus is a third-party library that simplifies communication between components by using annotations. It is useful when you need to decouple components and reduce the amount of boilerplate code required to send and receive events. EventBus can be more efficient than Intents because it doesn't require serialization, but it can be less efficient than LocalBroadcastManager because it uses reflection to find event subscribers. Additionally, EventBus can be more difficult to debug because event subscribers are not explicitly defined in code.
