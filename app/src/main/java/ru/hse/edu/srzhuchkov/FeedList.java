package ru.hse.edu.srzhuchkov;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedList implements KvmSerializable {
    @XmlElementWrapper(name = "feeds")
    @XmlElement(name = "feed")
    ArrayList<Feed> feeds;

    public FeedList() {
    }

    public FeedList(ArrayList<Feed> feeds) {
        this.feeds = feeds;
    }

    public ArrayList<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public Object getProperty(int index) {
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void setProperty(int index, Object value) {

    }

    @Override
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {

    }
}
