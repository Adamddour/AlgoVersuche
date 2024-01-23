package vorbereiten;

	public class BinarySearchTree {

		private Treenode root;
	

    public BinarySearchTree(int value) {
        root = new Treenode(value);
    }

    //1.1.a
    public boolean find(int value) {
        Treenode node = root;
        while (node != null) {
            if (value < node.wert) {
            	node = node.firstChild;
            } else if (value > node.wert) {
            	node = node.secondChild;
            } else {
                return true;
            }
        }
        return false;
    }

    //1.1.b
    public boolean add(int value) {
        if (root == null) {
            root = new Treenode(value);
            return true;
        }

        return addNode(root, value);
    }
    
    
    
    //1.1.b
    private boolean addNode(Treenode node, int value) {
        if (value < node.wert) {
            if (node.firstChild == null) {
                node.firstChild = new Treenode(value);
                return true;
            } else {
                return addNode(node.firstChild, value);
            }
        } else if (value > node.wert) {
            if (node.secondChild == null) {
                node.secondChild = new Treenode(value);
                return true;
            } else {
                return addNode(node.secondChild, value);
            }
        } else {
            return false; 
        }
    }

    

    //1.2
    private String print_structure(Treenode node) {
    	
        return (node != null) ? node.wert + " { " 
    + print_structure(node.firstChild) 
    + print_structure(node.secondChild) 
    + " } " : " null ";
        
        
    }
    
    public String print() {
	    return inOrder(root)+"\n";
	}


	private String inOrder(Treenode node) {
	    return "[" + inOrderTraversal(node) + "]";
	}

	private String inOrderTraversal(Treenode node) {
	    return (node != null) ? inOrderTraversal(node.firstChild) 
	    + " " + node.wert + " " + inOrderTraversal(node.secondChild) : "";
	}
	
	/*
	private String preOrder(Treenode node) {
	    return (node != null) ? node.wert 
	    		+ " {" + preOrder(node.firstChild) 
	    		+ preOrder(node.secondChild) + " } " : " null ";
	}
	
	private String postOrderTraversal(Treenode node) {
	    return (node != null) ? inOrderTraversal(node.firstChild) 
	     + " " + inOrderTraversal(node.secondChild)+ node.wert : "";
	}*/
    
    //1.2
    /*public String print() {
        return print_structure(root);
    }*/
    
    /********Oder************/
    /*private String print_structure(Treenode node) {
		String print = "";
		if (node.firstChild != null) {
			 print += print_structure(node.firstChild);
		}
		
		if (node.secondChild != null) {
			 print += print_structure(node.secondChild);
		}
		print += " " + node.wert;
		return print;
	}*/
  //Ende_1.2
    /***************************/
    
    
    /**********Anfang_Remove**********/  
    //Hier die zusatz Methode delete/remove();
    
    public boolean delete(int value) {
        // Initialisiere root mit dem aktualisierten Baum nach dem Löschen
        root = deleteNode(root, value);
        return true;
    }
    
   private Treenode deleteNode(Treenode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.wert) {
            node.firstChild  = deleteNode(node.firstChild, value);
        } else if (value > node.wert) {
            node.secondChild = deleteNode(node.secondChild, value);
        } else {
            // Element gefunden, löschen
            if (node.firstChild == null) {
                return node.secondChild;
            } else if (node.secondChild == null) {
                return node.firstChild;
            }

            // Knoten mit zwei Kindern, ersetze durch Inorder-Nachfolger
            node.wert = minValue(node.secondChild);
            node.secondChild = deleteNode(node.secondChild, node.wert);
        }
        return node;
    }
    
    
   /* private Treenode deleteNode(Treenode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.wert) {
            node.firstChild = deleteNode(node.firstChild, value);
        } else if (value > node.wert) {
            node.secondChild = deleteNode(node.secondChild, value);
        } else {
            // Element gefunden, löschen
            if (node.firstChild == null) {
                return null;
            } 
            node.secondChild = deleteNode(node.firstChild, value);
        }
        return node;
    }*/
     
    
    
    /*********End_Remove*********/
    
    //gehoehrt zu End_Remove
    private int minValue(Treenode node) {
        int minValue = node.wert;
        while (node.firstChild != null) {
            minValue = node.firstChild.wert;
            node = node.firstChild;
        }
        return minValue;
    }
    
    //
    
    
    // Hier die zusatz Methode Height();

    /*public static int height(Treenode p) {
        if (p == null) {
            return -1; // Höhe eines leeren Baumes ist -1
        } else {
            int firstChild = height(p.firstChild);
            int secondChild = height(p.secondChild);
            return 1 + Math.max(firstChild, secondChild);
        }
    }*/
    
    public int height() {
        return heightRecursive(root);
    }

    private  int heightRecursive(Treenode node) {
        if (node == null) {
            return -1; // Höhe eines leeren Baumes ist -1
        } else {
            int leftHeight = heightRecursive(node.firstChild);
            int rightHeight = heightRecursive(node.secondChild);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
    
    
    public int depth() {
        return depthRecursive(root);
    }

    private  int depthRecursive(Treenode node) {
        if (node == null) {
            return -1; // Tiefe eines leeren Baumes ist -1
        } else {
            int leftDepth = depthRecursive(node.firstChild);
            int rightDepth = depthRecursive(node.secondChild);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
    
    /***********Anfang_depth_Methode************/
    /*public static int depth(Treenode root, int value) {
        return depthRecursive(root, value, 0);
    }*/

    /*private static int depthRecursive(Treenode node, int value, int currentDepth) {
        if (node == null) {
            return -1; // Der Wert wurde nicht im Baum gefunden
        }

        if (node.wert == value) {
            return currentDepth; // Tiefe des gefundenen Werts
        }

        int leftDepth = depthRecursive(node.firstChild, value, currentDepth + 1);
        if (leftDepth != -1) {
            return leftDepth; // Der Wert wurde im linken Unterbaum gefunden
        }

        int rightDepth = depthRecursive(node.secondChild, value, currentDepth + 1);
        return rightDepth; // Der Wert wurde im rechten Unterbaum gefunden oder nicht im Baum vorhanden
    }
	*/
    
    /***********Ende_depth_Methode************/
    
    public Treenode getRoot() {
        return root;
    }
    
    /****************Heute**********************/
    //Nachfolger
    public Integer getSuccessor(int value) {
    	Treenode current = root; 
		Integer nextBigger = Integer.MAX_VALUE; 
		
		while (current != null) { 
			if (current.wert < nextBigger && current.wert > value) {
				nextBigger = current.wert; 
			}
			
			if (value < current.wert) { 
				current = current.firstChild; 
			} else if (value > current.wert) { 
				current = current.secondChild; 
			} else { 
				break; 
			} 
		}
		
		if (current == null || current.wert != value) {
			return null; 
		}
		
		if (current.secondChild != null) { 
			current = current.secondChild; 
			while (current.firstChild != null) { 
				current = current.firstChild; 
			}
			return current.wert; 
		} else {
			return (nextBigger < Integer.MAX_VALUE ? nextBigger : null);
		}
	} 
    
    
   /****************Heute**********************/
    //Min
    public int getMin() { 
    	Treenode current = root;
		while (current.firstChild != null) {
			current = current.firstChild; 
		}
		return current.wert;
	}
    
    //Max
    public Integer getMax() {
        if (root == null) {
            return null;
        }

        Treenode current = root;
        while (current.secondChild != null) {
            current = current.secondChild;
        }

        return current.wert;
    }

    //den Vorgänger eines gegebenen Werts zu erhalten.
    public Integer getPredecessor(int value) {
        Treenode current = root;
        Integer prevSmaller = null;

        while (current != null) {
            if (current.wert < value) {
                prevSmaller = current.wert;
            }

            if (value < current.wert) {
                current = current.firstChild;
            } else if (value > current.wert) {
                current = current.secondChild;
            } else {
                break;
            }
        }

        if (current == null || current.wert != value) {
            return null;
        }

        if (current.firstChild != null) {
            current = current.firstChild;
            while (current.secondChild != null) {
                current = current.secondChild;
            }
            return current.wert;
        } else {
            return prevSmaller;
        }
    }

	
}
