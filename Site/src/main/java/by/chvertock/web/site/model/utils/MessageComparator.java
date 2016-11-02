package by.chvertock.web.site.model.utils;

import java.util.Comparator;

import by.chvertock.web.site.model.entities.forum.Message;

public class MessageComparator implements Comparator<Message>{
	@Override
	public int compare(Message first, Message second) {
//	    System.out.println("[" + first.getTimestamp() + "]" + first.getText());
//	    System.out.println("[" + second.getTimestamp() + "]" + second.getText());
	    return (int) (first.getTimestamp().getTime() - second.getTimestamp().getTime());
	}
		
}
