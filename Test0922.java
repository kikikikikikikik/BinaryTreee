import java.util.*;

/**
 * @ClassName Test0922
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/22  9:08
 * @Veresion 1.0
 */
public class Test0922 {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static Node Tree(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        Node n8=new Node(8);
        n1.left=n2;n1.right=n3;n2.left=n4;n2.right=n5;n3.left=n6;n3.right=n7;n5.right=n8;
        return n1;
    }
    //层序遍历
    public static void LevelOrder(Node root){
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
    //二叉树的前序非递归
    public static void preorder1(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
    }
    public static List<Integer> preorder2(Node root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
        return list;
    }
    //二叉树的中序非递归
    public static void inorder(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            Node top=stack.pop();
            System.out.println(top.val);
            cur=top.right;
        }
    }
    public  static List<Integer> inorder2(Node root){
        Stack<Node> stack=new Stack<>();
        List<Integer> list=new LinkedList<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            list.add(top.val);
            cur=top.right;
        }
        return list;
    }
    //二叉树的后序非递归
    public static void postorder(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        Node last=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.peek();
            if(top.right==null||top.right==last){
                System.out.println(top.val);
                stack.pop();
                last=top;
            }
            else{
                cur=top.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root=Tree();
        //LevelOrder(root);
        postorder(root);
    }
}
