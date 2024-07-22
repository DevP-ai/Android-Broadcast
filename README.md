# Android-Broadcast

## Broadcast Receiver
 -> Broadcast in android is the system-wide events that can occur when the device starts, when a message is received on the device or when incoming calls are received,or when device goes to aiplane modes, etc.
 
 -> Broadcast Receivers are used to respond to these system-wide events.

 -> Broadcast receivers allow us to register for the system and application events, and when that event happens, then the register receivers get notified.

 -> Broadcast can be sent globally ot locally abd can be received by any registered app.

 <b>There are mainly two types of Broadcast Receivers:</b>

   <b>1.Static Broadcast Receivers: </b>These types of receivers are declared in the manifest file and works even if the app is closed.

   <b>2.Dynamic Broadcast Receivers: </b>These types of receivers work only if the app is active or minimized.

## Intent Filters

 -> In Android development, intent filters are used to specify which intents an activity, service, or broadcast receiver is willing to receive. In addition to actions, intent filters can use categories to provide more precise matching of intents.

 -> Categories are used to declare additional information about the kind of component that should handle the intent. 

 -> When an intent is sent with a specific action and category, the system will only match it to components that have declared the same action and category in their intent filter.

 -> By using categories in addition to actions, you can ensure that your component only receives intents that are relevant to its functionality.
 

   
