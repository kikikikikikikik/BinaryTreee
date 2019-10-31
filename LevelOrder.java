import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LevelOrder
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/21  18:55
 * @Veresion 1.0
 */
public class LevelOrder {
    public static void LevelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node front=queue.remove();
            System.out.println(front.val);
            if(front.left!=null){
                queue.offer(front.left);
            }
            if(front.right!=null){
                queue.offer(front.right);
            }
        }

    }
    private static class NodeLevel{
        int level;
        Node node;
        public NodeLevel(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public static void LevelOrder2(Node root){
        if(root==null){
            return ;
        }
        Queue<NodeLevel> queue=new LinkedList<>();
        queue.offer(new NodeLevel(root,1));
        while(!queue.isEmpty()){
           NodeLevel node=queue.remove();
            System.out.println(node.level+":"+node.node.val);
            if(node.node.left!=null){
                queue.add(new NodeLevel(node.node.left,node.level+1));
            }
            if(node.node.right!=null){
                queue.add(new NodeLevel(node.node.right,node.level+1));
            }
        }
    }
    public static boolean isComTree(Node root){
        if(root==null){
            return true;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(true){
            Node front=queue.poll();
            if(front==null){
                break;
            }
            queue.offer(front.left);
            queue.offer(front.right);
        }
        while(queue.isEmpty()){
            Node node=queue.poll();
            if(node!=null){
                return false;
            }
        }
        return true;
    }
}
