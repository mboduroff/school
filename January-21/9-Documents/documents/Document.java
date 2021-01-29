package documents;

import java.util.Scanner;

public class Document {
    private String recipient;
    private String sender;
    private String documentType;
    private String mainBody;

    static Scanner sc = new Scanner(System.in);

    public Document(String recipient, String sender, String documentType, String mainBody) {
        this.recipient = recipient;
        this.sender = sender;
        this.documentType = documentType;
        this.mainBody = mainBody;
    }

    public Document() {
        System.out.println("---< Нов документ >---\n" +
                "Моля, въведете следните полета:\n");
        System.out.print("Име на получателя: ");
        this.recipient = sc.next();
        System.out.print("Вашето име: ");
        this.sender = sc.next();
        System.out.print("Тип на документа: ");
        this.documentType = sc.next();
        System.out.print("Съдържание на документа: ");
        this.mainBody = sc.nextLine();
    }


    @Override
    public String toString() {
        return String.format("\t\t\t\t\t\t\t\t\t\t%s%n%n\t\t\t\t\t%s%n%n\t\t\t\t\t%s%n%n\t\t%s%n%s%n%n\t\t\t\t\t\t\t\t\t\t%s%n\t\t\t\t\t\t\t\t\t\t%s",
                ("До " + this.recipient),
                this.documentType,
                ("От " + this.sender),
                ("Уважаеми г-н/г-жо " + this.recipient + ","),
                this.mainBody,
                ("С Уважение,\n\n" + "\t\t\t\t\t\t\t\t\t\t...................."),
                ("/" + this.sender + "/"));
    }
}
