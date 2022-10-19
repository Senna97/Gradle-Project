package week05.e1019.stack;

public class Stack01 {

    private int[] arr = new int[10000]; // 기본 사이즈
    private int pointer = 0;

    public Stack01() {
    }

    public Stack01(int size) { // 매개변수로 사이즈 입력 가능
        this.arr = new int[size];
    }

    public void push(int value) {
        this.arr[this.pointer] = value;
        this.pointer++;
    }

    public int[] getArr() {
        return arr;
    }
}
