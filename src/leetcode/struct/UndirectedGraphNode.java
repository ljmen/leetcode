package leetcode.struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	public UndirectedGraphNode(String graphStr) {
		String[] strs = graphStr.split("#");
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		for (int i = strs.length - 1; i >= 0; i--) {
			String[] str = strs[i].split(",");
			int label = Integer.valueOf(str[0]);
			UndirectedGraphNode node = new UndirectedGraphNode(label);
			for (int j = 1; j < str.length; j++) {
				int nextLabel = Integer.valueOf(str[j]);
				if (nextLabel == label) {
					node.neighbors.add(node);
				} else {
					if (!map.containsKey(nextLabel))
						System.out.println("something must be wrong");
					node.neighbors.add(map.get(nextLabel));
				}
			}
			map.put(label, node);
		}
		this.label = Integer.valueOf(graphStr.split(",")[0]);
		this.neighbors = map.get(Integer.valueOf(graphStr.split(",")[0])).neighbors;
	}

	@Override
	public String toString() {
		String graphStr = "";
		Set<Integer> set = new HashSet<Integer>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(this);
		while (queue.size() != 0) {
			UndirectedGraphNode[] nodes = queue
					.toArray(new UndirectedGraphNode[queue.size()]);
			queue.clear();

			for (UndirectedGraphNode node : nodes) {
				if (set.contains(node.label))
					continue;
				set.add(node.label);
				String sub = String.valueOf(node.label);
				for (UndirectedGraphNode neighbor : node.neighbors) {
					sub += "," + neighbor.label;
					if (neighbor.label != node.label)
						queue.add(neighbor);

				}
				graphStr += sub + "#";
			}
		}

		return graphStr.substring(0, graphStr.length() - 1);
	}

	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(
				"-498,-497,454,994#-497,-496#-496,-490,-376,10#-490,-487,-238,472#-487,-484,154,243#-484,-479,704#-479,-477,864,875#-477,-476,636#-476,-472#-472,-466#-466,-457,868#-457,-453#-453,-448#-448,-446,201#-446,-441#-441,-440#-440,-434,643#-434,-433,479#-433,-432#-432,-431#-431,-421#-421,-419,-418,879#-419,-418#-418,-414,-38,826#-414,-413,15#-413,-410#-410,-408,-144#-408,-407,963#-407,-398,803#-398,-394,629#-394,-393#-393,-392,76#-392,-390,-380#-390,-389,372,457,463#-389,-388,-367#-388,-386#-386,-382#-382,-380#-380,-376#-376,-375#-375,-374#-374,-373,840#-373,-367#-367,-363#-363,-362#-362,-357#-357,-356#-356,-354#-354,-353#-353,-352,839#-352,-351#-351,-344#-344,-343,15,377#-343,-337,127#-337,-332,-215,-205,869#-332,-331#-331,-323,805#-323,-319,839#-319,-316#-316,-311,-205,66,883#-311,-307#-307,-293#-293,-291#-291,-290,383#-290,-289#-289,-287,691#-287,-284,680,839,958#-284,-275#-275,-274,721,962#-274,-273,202#-273,-269,416#-269,-267#-267,-265#-265,-263,883#-263,-258#-258,-239,-30#-239,-238,414#-238,-237,953#-237,-234#-234,-230,-180#-230,-229#-229,-224,-57#-224,-223,284#-223,-215#-215,-214#-214,-212,280#-212,-210,777,889#-210,-205,328#-205,-201,-135#-201,-198,-90#-198,-194#-194,-192#-192,-185,638#-185,-183,782#-183,-180#-180,-179#-179,-176,-84#-176,-175#-175,-174#-174,-173#-173,-165,575#-165,-164,-115#-164,-150,282#-150,-149,2#-149,-148#-148,-145#-145,-144,-76,487#-144,-142#-142,-140#-140,-138#-138,-135,-38#-135,-132#-132,-128,173,758#-128,-127#-127,-121#-121,-119#-119,-115#-115,-113#-113,-108,52,282#-108,-97,817#-97,-96#-96,-90#-90,-88#-88,-87#-87,-84,-32,645#-84,-82,813#-82,-80,-80,596#-80,-79,380,846#-79,-76#-76,-75#-75,-72,-30#-72,-70#-70,-69#-69,-67,-16,224#-67,-63#-63,-62#-62,-57,-3,767#-57,-52,301#-52,-45,179#-45,-43,195#-43,-42#-42,-41#-41,-38#-38,-37#-37,-36,173#-36,-35,95#-35,-32,-28,950#-32,-31,338#-31,-30#-30,-28,939#-28,-25#-25,-19#-19,-17#-17,-16#-16,-15#-15,-14,66#-14,-11,638#-11,-7,303,839#-7,-6#-6,-4,596#-4,-3#-3,0#0,2,208#2,4,875#4,6#6,10,887#10,13,867#13,15#15,26#26,32,524#32,33#33,38#38,43#43,44,744#44,49#49,50#50,52#52,57,243#57,62,179#62,63#63,66,864#66,68,946#68,70,337,373#70,73#73,73,76,782#76,77#77,79#79,80#80,84#84,86,536#86,88#88,92#92,95#95,98#98,100,705#100,102,414#102,103#103,117,457#117,118#118,122#122,124#124,127#127,134,659#134,136#136,137,507,529#137,145,728#145,149#149,154#154,155,537#155,160,188#160,161,360#161,162#162,173,389,846#173,175,320#175,178#178,179#179,180,862#180,181#181,184#184,187#187,188#188,194#194,195#195,197#197,201,416,533,977#201,202#202,205,389#205,208#208,210#210,212,295#212,213#213,218,865#218,224#224,227#227,238#238,243#243,250#250,251,282,953#251,257#257,260#260,263#263,265#265,267,303#267,268#268,269,385,612#269,270#270,271#271,274#274,280,982#280,282,659#282,284#284,289#289,290#290,291#291,292#292,295#295,300,506#300,301,327,575,777#301,302,383#302,303#303,307#307,315#315,316#316,318,415#318,319#319,320,327,383,595#320,323#323,324,458#324,326,492,638#326,327#327,328#328,329#329,330#330,331#331,334#334,337#337,338#338,340#340,341#341,343#343,349#349,360#360,361#361,370#370,372#372,373#373,376,406,851#376,377#377,380,874#380,383#383,385#385,389#389,394#394,402#402,406#406,408#408,409#409,411#411,412#412,414#414,415#415,416#416,422,698#422,423#423,424,471#424,427#427,438,748#438,440,549#440,446#446,449#449,450#450,453#453,454#454,456#456,457#457,458#458,463,616#463,468,526#468,471#471,472#472,476,767,922#476,479#479,487#487,490#490,492,612,716#492,496#496,498,777#498,505,650#505,506#506,507#507,513#513,519#519,522#522,523#523,524#524,526#526,527#527,529#529,533,657#533,536#536,537,682,934#537,539#539,549#549,553#553,554#554,559#559,565,770,867#565,566#566,572#572,575#575,576,786#576,578,956#578,582#582,589#589,595#595,596,645,757,786#596,601#601,603#603,607#607,612,803#612,616#616,617#617,618#618,619#619,625,944#625,626#626,627#627,629,865#629,630#630,632#632,633#633,635#635,636,796,802#636,638#638,639#639,643#643,645#645,646#646,650#650,657#657,659#659,660#660,663#663,666,791#666,668#668,672#672,678,959#678,680,802#680,682#682,691#691,693#693,694#694,698,758#698,704#704,705#705,707#707,708#708,710#710,712#712,713#713,716#716,721#721,723#723,726#726,728#728,731#731,734#734,735#735,736#736,744#744,748#748,749#749,750#750,756#756,757,879#757,758,982#758,760#760,761#761,765#765,767#767,770#770,777#777,779#779,782#782,786#786,788#788,790#790,791#791,794#794,796#796,800#800,801#801,802#802,803#803,804#804,805#805,806#806,813,979#813,815,859#815,817#817,823#823,825#825,826#826,828#828,832#832,839#839,840#840,846#846,850#850,851#851,855#855,856#856,859#859,862,864#862,864#864,865#865,867#867,868#868,869#869,871,965#871,872#872,874#874,875#875,877#877,879#879,880#880,881#881,883#883,887#887,888#888,889#889,890#890,893#893,895#895,900#900,901#901,922#922,925#925,926#926,933#933,934#934,939#939,942#942,944#944,946#946,950#950,953#953,955#955,956#956,958#958,959#959,962#962,963#963,965#965,970#970,977#977,979#979,982#982,994#994");
		System.out.println(node);
	}
}
