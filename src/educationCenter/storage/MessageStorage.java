package educationCenter.storage;

import educationCenter.model.Message;

public class MessageStorage {
    private Message[] messages = new Message[16];
    private int size = 0;

    public void add(Message message) {
        messages[size++] = message;
        if (size == messages.length) {
            extend();
        }
    }

    private void extend() {
        Message[] tmp = new Message[messages.length + 10];
        System.arraycopy(messages, 0, tmp, 0, messages.length);
        messages = tmp;
    }
    public Message getMessage(int index){
        if (index<=size){
            return messages[index];
        }
        return null;
    }
    public int getSize(){
        return size;
    }
public void printMessages(){
    for (int i = 0; i <size ; i++) {
        System.out.println(messages[i]);

    }
}
}
