import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Shaun on 8/28/2016.
 */

public class solution{
    static Graph buildgragh(String[] projects, String[][] deps){
        Graph graph = new Graph();
        int count = 0;
        for(String name: projects){
            graph.createNode(name);
        }
        for(String[] temp: deps){
            graph.addEdge(temp[0],temp[1]);
        }
        return graph;
    }

    static ArrayList<String> returnOrder(Graph graph){
        ArrayList<String> order = new ArrayList<>();
        ArrayList<Project> parent = new ArrayList<>();
        ArrayList<Project> nodeList = graph.getNodes();

        for(Project project: graph.getNodes()){
            if(project.getNumOfParent() == 0){
                parent.add(project);
            }
        }

        while (!parent.isEmpty()){
            for (Project temp: parent){
                //System.out.println(temp.getName());
            }
            order.add(parent.get(0).getName());
            for(Project children: parent.get(0).getChildren()){
                //System.out.println("C "+children.getName()+children.getNumOfParent());
                children.subParent();
                if(children.getNumOfParent() == 0){
                    parent.add(children);
                }
            }
            parent.remove(parent.get(0));
        }
        return order;
    }

    public static void main(String[] args){
        String[] nodes= {"a","b","c","d","e","f"};
        String[][] deps = {{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};
        Graph g = buildgragh(nodes, deps);
        ArrayList<String> order = returnOrder(g);
        for (String name: order){
            System.out.println(name);
        }

    }
}
class Graph{
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public void buildGraph(){

    }

    public void addEdge(String parent, String child){
        if(!map.containsKey(parent)){
            createNode(parent);
        }
        if(!map.containsKey(child)){
            createNode(child);
        }
        map.get(parent).addChild(map.get(child));
    }

    public void createNode(String name){
        Project project = new Project(name);
        nodes.add(project);
        map.put(name,project);
    }

    public ArrayList<Project> getNodes(){
        return nodes;
    }
}

class Project{
    private String name;
    private ArrayList<Project> childrenList= new ArrayList<>();
    private HashMap<String, Project> nameMap = new HashMap<>();
    private int numOfParent = 0;

    public Project(String n){
        name = n;
    }

    public int getNumOfParent(){
        return numOfParent;
    }

    public String getName(){
        return name;
    }

    public void addParent(){
        numOfParent++;
    }

    public void subParent(){
        numOfParent--;
    }

    public void addChild(Project child){
        childrenList.add(child);
        nameMap.put(child.getName(), child);
        child.addParent();
    }

    public ArrayList<Project> getChildren() {
        return childrenList;
    }
}