package com.aspire.training.functional.threading;

public class PublicationThisRefExample {
    private int counter =0;
    public PublicationThisRefExample(EventSource event) {
//        event.register(this);
        //do another operation
        //Not good to start thread here
        //You can create thread but at least don't start it in cons
    }
}
