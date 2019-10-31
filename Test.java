import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/17  18:35
 * @Veresion 1.0
 */
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
    }
}
public class Test {
    //利用中序和前序构造二叉树
    public Node buildTree(int[] preorder,int[] inorder){
        if(preorder==null){
            return null;
        }
        int rootValue=preorder[0];
        int leftcount;
        for(leftcount=0;leftcount<inorder.length;leftcount++){
            if(inorder[leftcount]==rootValue){
                break;
            }
        }
        Node root=new Node(rootValue);
        int[] leftPreorder= Arrays.copyOfRange(preorder,1,1+leftcount);
        int[] leftInorder=Arrays.copyOfRange(inorder,0,leftcount);
        root.left=buildTree(leftPreorder,leftInorder);
        int[] rightPreorder=Arrays.copyOfRange(preorder,leftcount+1,preorder.length);
        int[] rightInorder=Arrays.copyOfRange(inorder,leftcount+1,inorder.length);
        root.right=buildTree(rightPreorder,rightInorder);
        return root;
    }
    public Node buildTree3(List<Integer> preorder,List<Integer> inorder){
        if(preorder.isEmpty()){
            return null;
        }
        int rootValue=preorder.get(0);
        int leftCount=inorder.indexOf(rootValue);
        List<Integer> leftpre=preorder.subList(1,1+leftCount);
        List<Integer> leftin=inorder.subList(0,leftCount);
        List<Integer> rightpre=preorder.subList(1+leftCount,preorder.size());
        List<Integer> rightin=inorder.subList(1+leftCount,inorder.size());
        Node root=new Node(rootValue);
        root.left=buildTree3(leftpre,leftin);
        root.right=buildTree3(rightpre,rightin);
        return root;
    }
     static class RT{
        Node root;
        int used;
        public RT(Node root,int used){
            this.root=root;
            this.used=used;
        }
    }
    RT buildTree1(List<Integer> preorder){

        if(preorder.isEmpty()){
            return new RT(null,0);
        }
        if(preorder.get(0)=='#'){
            return new RT(null,1);
        }
        RT left=buildTree1(preorder.subList(1,preorder.size()));
        RT right=buildTree1(preorder.subList(left.used,preorder.size()));
        Node root=new Node(preorder.get(0));
        root.left=left.root;
        root.right=right.root;
        RT rt=new RT(root,1+left.used+right.used);
        return rt;
    }
    //利用后序和中序构造二叉树
    public Node buildTree2(int[] postorder,int[] inorder){
        if(postorder==null){
            return null;
        }
        int rootValue=postorder[postorder.length-1];
        int leftcount;
        for(leftcount=0;leftcount<inorder.length;leftcount++){
            if(inorder[leftcount]==rootValue){
                break;
            }
        }
        Node root=new Node(rootValue);
        int[] leftpost=Arrays.copyOfRange(postorder,0,leftcount);
        int[] leftinorder=Arrays.copyOfRange(inorder,0,leftcount);
        root.left=buildTree2(leftpost,leftinorder);
        int[] rightpost=Arrays.copyOfRange(postorder,leftcount,postorder.length-1);
        int[] rightinorder=Arrays.copyOfRange(inorder,leftcount+1,inorder.length);
        root.right=buildTree2(rightpost,rightinorder);
        return root;
    }
    public boolean Search(Node root1,Node root2){
        if(root1==null){
            return false;
        }
        if(isSameTree2(root1,root2)){
            return true;
        }
        if(Search(root1.left,root2)){
            return true;
        }
        return Search(root1.right,root2);
    }

    public List<Integer> postOrderTraversal2(Node root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
        return new ArrayList<>();
    }
        List<Integer>left= postOrderTraversal2(root.left);
        List<Integer>right=postOrderTraversal2(root.right);
       list.addAll(left);
       list.addAll(right);
        list.add(root.val);
        return list;
    }
    public boolean isSameTree2(Node s,Node t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        return isSameTree2(s.left,t.left)&&isSameTree2(s.right,t.right)&&s.val==t.val;
    }
    public boolean isSubTree2(Node s,Node t){
       if(s==null){
           return false;
       }
        if(isSameTree2(s,t)){
            return true;
        }
        return isSubTree2(s.left,t)||isSubTree2(s.right,t);
    }
   public static int[] Swap(int[] A){
       int max=Integer.MIN_VALUE;
       int maxIndex=-1;
    for(int i=A.length-2;i>=0;i++){
        if(A[i]>A[i+1]){
            for(int j=i+1;j<A.length;j++){
                if(A[i]>A[j]&&A[j]>max){
                    max=A[j];
                    maxIndex=j;
                }

            }
            int t=A[i];
            A[i]=A[maxIndex];
            A[maxIndex]=t;
            return A;
        }


    }
    return A;
    }
    public static String tree2str(Node root) {
        String s = "";
        if (root != null) {
            s+='(';
            s+=root.val;
            if (root.left == null && root.right == null) {
            }
            else if (root.left != null && root.right == null) {
                tree2str(root.left);
            } else if (root.left == null && root.right != null) {
                s += "()";
                s += tree2str(root.right);
            }
            else{
                s+=tree2str(root.left);
                s+=tree2str(root.right);
            }
            s+=')';
        }
        return s;
    }
}
