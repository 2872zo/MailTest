import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Store;

public class main {
	public static void main(String[] args) throws Exception {
		readEmail();
	}
	
	public static void readEmail() throws Exception {  
//        IMAPAgent mailagent = new IMAPAgent("IMAPSeverUrl", "port", "emailAddress", "password");
		IMAPAgent mailagent = new IMAPAgent("imap.daum.net", "993", "2872zo@daum.net", "lkj6322*");
		
        mailagent.open();  
//        mailagent.createFolder("newFolder");  
//        Message[] msg = mailagent.getRecentMessages(5);  
//        for(Message m : msg) {  
//            System.out.println("subject: "+m.getSubject());  
//            System.out.println("MsgNum: "+m.getMessageNumber());  
//            System.out.println("UID: "+mailagent.getUID(m));  
//            System.out.println("Sent Date: "+m.getSentDate());  
////            mailagent.setUnSeenFlag(m);  
//        }  
//        mailagent.moveMessage(msg, mailagent.getDefaultFolder(), mailagent.getFolder("newFolder"));  
        
        
//        mailagent.getPersonalFolders();
//        mailagent.getSharedFolders();
//        mailagent.getUserFolders("newFolder");
        
//        System.out.println("Count : " + mailagent.getFolder("ÇÃ½º").getMessageCount());
        Store store = mailagent.getStore();
        
        Folder[] f = store.getDefaultFolder().list(); 
        for(Folder fd:f) 
            System.out.println(">> "+fd.getName()); 
        
        
        mailagent.close();  
        
    }  
}
