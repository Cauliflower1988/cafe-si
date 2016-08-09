package org.springframework.integration.samples.cafe;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.router.AbstractMessageRouter;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by cemartins on 8/9/16.
 */
public class MyRouter extends AbstractMessageRouter {

    private MessageChannel drinks;

    private MessageChannel bites;

    public MessageChannel getDrinks() {
        return drinks;
    }

    public void setDrinks(MessageChannel drinks) {
        this.drinks = drinks;
    }

    public MessageChannel getBites() {
        return bites;
    }

    public void setBites(MessageChannel bites) {
        this.bites = bites;
    }

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {

        Class<?> type = message.getPayload().getClass();

        if(type == ElementNSImpl.class) {
            ElementNSImpl nsPayload = (ElementNSImpl) message.getPayload();
            final String localName = nsPayload.getLocalName();
            if(localName.equals("Drink")) {
                return Collections.<MessageChannel>singletonList(drinks);
            }
            else {
                return Collections.<MessageChannel>singletonList(bites);
            }
        }
        else
            return null;
    }
}
