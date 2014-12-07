HOWTOKILLAMOCKINGDROID
======================

cave man dependency injection


The idea was to explore manual dependency injection without using anything too fancy like Roboguic or Dagger.
I noticed that Dagger is set up so that the base Activity class injects itself into the Application class and thus
the object graph. I decided to try this manually to see where it would take me and what that would look like.
Right now the idea is that every object calls the method inject on the Application class and it passes itself as a parameter.
This is how dagger does it so i copied it. I then just take that method call at the Application level and forward it to 
a class method on the class InversionContainer. This class takes the object type and does some pattern matching
to decide what to do with the incomming object. In the case of MainActivity it decides to inject a JSONService singleton into 
the MainActivity through it's public setter.  MainActivity calls the inject right after it calls super.onCreate(). This lets
us inject any dependencies before the user really tries to use them. I'm not forcing this through a baseclass like dagger.
I'm just keeping it simple so that it is obvious that you are injecting yourself into the Application class.
What i found interesting was that theoretically every object's constructor could inject itself via the inject method and we
could just route the object depending on the type. This way for instance, when we inject JSONService into MainActivity, you may
notice that JSONService has a dependency on an HttpClient. We inject this HttpClient into JSONService when the JSONService is created.
This is more of an experiment but it does look like for simpler projects you can do dependency injection by using
the Application class as a entry point for the InversionOfControl container. In the unit tests you can see that
we just create a Mokito fake for the MainApplication class and we set up mokito stubs that handle all the inject calls.
This lets us mock out the services and other dependencies that the unit under test requires.
