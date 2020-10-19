package Graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationImageServer;

public class Tree {

	JFrame frame = new JFrame();
	DirectedSparseMultigraph<String, String> g = new DirectedSparseMultigraph<String, String>();

	public void add(String root, String node, double rootPos, double nodePos) {

		String drawNode = node + " " + nodePos;
		String drawRoot = root + " " + rootPos;

		// If current node is parent
		if (g.containsVertex(drawNode)) {
			drawNode = drawNode + " ";
		}
		
		// If current node is child (leaf)
		if (g.containsEdge(drawRoot)) {
			drawRoot = drawRoot + " ";
		}

		g.addVertex(drawNode);
		g.addEdge(drawRoot.toString() + drawNode.toString(), drawRoot, drawNode, EdgeType.DIRECTED);

		Layout<String, String> layout = new FRLayout<String, String>(g);
		layout.setSize(new Dimension(400, 400));
		VisualizationImageServer<String, String> vv = new VisualizationImageServer<String, String>(layout,
				new Dimension(500, 500));
		// layout.lock(node, true);
		vv.getRenderContext().setVertexLabelTransformer(new Transformer<String, String>() {
			public String transform(String e) {
				return (e.toString());
			}
		});

		Transformer<String, Paint> vertexColor = new Transformer<String, Paint>() {
			public Paint transform(String i) {
				if (i.equals(node.toString())) {
					return Color.GREEN;
				}
				return Color.RED;
			}
		};

		vv.getRenderContext().setVertexFillPaintTransformer(vertexColor);

		// Label lab = new Label("Name: ");
		// lab.setBounds(50, 50, 80, 20);
		// frame.add(lab);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (

		InterruptedException e1) {
			e1.printStackTrace();
		}

	}

}
