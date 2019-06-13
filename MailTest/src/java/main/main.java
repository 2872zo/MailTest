import javax.mail.Message;

public class main {
	public static void main(String[] args) throws Exception {
		readEmail();
	}
	
	public static void readEmail() throws Exception {  
        IMAPAgent mailagent = new IMAPAgent("IMAPSeverUrl", "emailAddress", "password");  
        mailagent.open();  
        mailagent.createFolder("newFolder");  
        Message[] msg = mailagent.getUnReadMessages();  
        for(Message m : msg) {  
            System.out.println("subject: "+m.getSubject());  
            System.out.println("MsgNum: "+m.getMessageNumber());  
            System.out.println("UID: "+mailagent.getUID(m));  
            System.out.println("Sent Date: "+m.getSentDate());  
            mailagent.setSeenFlag(m);  
        }  
        mailagent.moveMessage(msg, mailagent.getDefaultFolder(), mailagent.getFolder("newFolder"));  
        mailagent.close();  
    }  
}
