import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BinaryTree
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/14  14:43
 * @Veresion 1.0
 */
public class BinaryTree {

    private static class Node{
        private char val;
        private Node left;
        private Node right;
        private Node(char val){
            this.val=val;
        }
        public String toString(){
            return String.format("{ %c }",val);
        }
    }
    //先序遍历
    public static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }
    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root==null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }
    //层序遍历
    //完全二叉树的判断
    public static boolean comBinaryTree(Node root){
        if(root==null){
            return true;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node front=queue.poll();
            if(front==null){
                break;
            }
            queue.offer(front.left);
            queue.offer(front.right);
        }
        while(!queue.isEmpty()){
            Node n=queue.poll();
            if(n!=null){
                return false;
            }
        }
        return true;
    }
    //遍历思路求结点的个数
    static int size=0;
    public static void getSize1(Node root){
        if(root==null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    //子问题思路求节点个数
    public static int getSize2(Node root){
        if(root==null){
            return 0;
        }
        int left=getSize2(root.left);
        int right=getSize2(root.right);
        return left+right+1;
    }
    //遍历思路求叶子节点个数
    static int count=0;
    public static void getLeafSize1(Node root){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            count++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    //子问题思路求叶子节点个数
    public static int getLeafSize2(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int l=getLeafSize2(root.left);
        int r=getLeafSize2(root.right);
        return l+r;
    }
    //子问题思路求第k层节点个数
    public static int getKLevel(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevel(root.left,k-1)+getKLevel(root.right,k-1);
    }
    //查找val所在结点
    public static boolean find2(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.val==val){
            return true;
        }
        boolean m=find2(root.left,val);
        if(!m)
            return find2(root.right,val);
        return false;
    }
   //判断两个二叉树是否相同
    public static boolean isSame(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        return root1.val==root2.val&&isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
    }
    //判断两个二叉树是否为镜像二叉树
    public static boolean isMirror(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        return root1.val==root2.val&&isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
    }
    //判断一棵二叉树是否为对称二叉树
    public static boolean isSymmetric(Node root){
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    //查找一个树中是否存在另一个树
    public static boolean isSubTree(Node s,Node t){
        if(isSame(s,t)){
            return true;
        }
        else if(isSame(s.left,t)){
            return true;
        }
        else return isSame(s.right,t);
    }
    //给定一个元素找树中是否存在
    Node find(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        Node left=find(root.left,val);
        if(left!=null){
            return left;
        }

        Node right=find(root.right,val);
        if(right!=null){
            return right;
        }
        return null;
    }
    public static Node buildtree(){
        Node a=new Node('A');
        Node b=new Node ('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node ('G');
        Node h=new Node ('H');
        a.left=b;a.right=c;b.left=d;b.right=e;c.left=f;c.right=g;e.right=h;
        return a;
    }

    public static void main(String[] args) {

        Node root=buildtree();
        //preOrderTraversal(root);
        getSize1(root);
        System.out.println(size);
        System.out.println(getSize2(root));
        getLeafSize1(root);
        System.out.println(count);
        System.out.println(getLeafSize2(root));
        System.out.println(getKLevel(root,5));
    }
}
