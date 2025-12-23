import java.util.ArrayList;

public class MessagingService {

    private ArrayList<Message> messagesList = new ArrayList<Message>();

    public void MessagingService(){


    }

    public void add(Message message){

        if(message.getContent().length() <= 280){

            messagesList.add(message);
        }
    }

    public ArrayList<Message> getMessages(){

        return messagesList;
    }
}
