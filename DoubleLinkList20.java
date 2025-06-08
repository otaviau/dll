public class DoubleLinkList20 {
    Node20 head, tail;
    int size;

    public DoubleLinkList20(){  
        head = null;
        tail = null;
        size = 0;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addFirst(Mahasiswa20 data){
        Node20 newNode = new Node20(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addLast(Mahasiswa20 data){
        Node20 newNode = new Node20(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void insertAfter(String keyNim, Mahasiswa20 data){
        Node20 current = head;

        while (current!=null && !current.data.nim.equalsIgnoreCase(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node dengan NIM "+keyNim+" tidak ditemukan.");
            return;
        }
        Node20 newNode = new Node20(data);

        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Node berhasil disisipkan setelah NIM "+ keyNim);
    }
    public void print(){
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        Node20 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }
        Mahasiswa20 removedData = head.data; 
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah " + removedData);
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }
        Mahasiswa20 removedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah " + removedData);
    }

    public Node20 search(String nim) {
        Node20 current = head;
        while (current != null) {
            if (current.data.nim.equalsIgnoreCase(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void add(int index, Mahasiswa20 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node20 newNode = new Node20(data);
            Node20 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }
    public void removeAfter(String keyNim) {
        Node20 current = head;
        while (current != null && !current.data.nim.equalsIgnoreCase(keyNim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node setelah NIM tersebut tidak ditemukan atau sudah di akhir.");
            return;
        }
        Node20 toDelete = current.next;
        if (toDelete == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = toDelete.next;
            toDelete.next.prev = current;
        }
        size--;
        System.out.println("Node setelah NIM " + keyNim + " berhasil dihapus.");
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node20 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        System.out.println("Node pada indeks " + index + " berhasil dihapus.");
    }
    public void getFirst() {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }
        System.out.println("Data di node pertama:");
        head.data.tampil();
    }
    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }
        System.out.println("Data di node terakhir:");
        tail.data.tampil();
    }
    public void getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node20 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data di indeks ke-" + index + ":");
        current.data.tampil();
    }
}