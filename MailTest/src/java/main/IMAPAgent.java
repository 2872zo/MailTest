import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.search.FlagTerm;

//MailAgent를 상송하여 IMAP 고유기능을 지원하는 클래스
public class IMAPAgent extends MailAgent{
	public IMAPAgent(String host, String id, String passwd) {  
        super(new IMAP(), host, id, passwd);  
    }  
      
    public Folder getFolder(String name) throws MessagingException {  
        return getStore().getFolder(name);  
    }  
      
    public Message[] getUnReadMessages() throws MessagingException {  
        return getDefaultFolder().search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));  
    }  
      
    public void createFolder(String name) throws MessagingException {  
        Folder folder = getStore().getFolder(name);  
        if( !folder.exists() ) {  
            folder.create(Folder.HOLDS_MESSAGES);  
        }  
    }  
      
    public void moveMessage(Message[] message, Folder src, Folder dest) throws MessagingException {  
        src.copyMessages(message, dest);  
        src.setFlags(message, new Flags(Flags.Flag.DELETED), true);  
    }  
      
    public void setSeenFlag(Message message) throws MessagingException {  
        setFlags(message, Flags.Flag.SEEN, true);  
    }  
      
    public void setUnSeenFlag(Message message) throws MessagingException {  
        setFlags(message, Flags.Flag.SEEN, false);  
    }  
      
    public void setFlags(Message message, Flag flag, boolean set) throws MessagingException {  
        message.setFlag(flag, set);  
    }  
      
    public boolean hasNewMessage(Folder folder) throws MessagingException {  
        return folder.hasNewMessages();  
    }     
}
