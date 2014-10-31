package model.test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import model.Assembly;

public class AssemblyTest {
	
	public static void main(String[] args) {
		Map<Integer,BigInteger> map = new HashMap<Integer, BigInteger>();
		Map<Integer,BigInteger> mapTmp = new HashMap<Integer, BigInteger>();
		
		map.put(new Integer(1), new BigInteger("72933824120662089890066566080220624344437661822117377718178190953091918056312494370276391673071643507728284401711825034904268094427929193064204920059832956788119199529377007656779664245637923408250391970815778262197052157925564805919747836198740139176246661539711202934317907575740087835247174768897661812665"));
		map.put(new Integer(2), new BigInteger("47097704142947411436985741098524058073866027565633965537854223138712515401209382914157516608009679724880995889304424002516997601522242381873848260680531409382117035446971774945589665950553310573233526813980915627012474557183409257299435547682233455429475085298468638999801966476087917152278059523789837656489"));
		map.put(new Integer(3), new BigInteger("27689681768491638309446654585947561357879588015148151249134697981463780755334244984995559484474900001841948471705107473494492822189640576474430033977696119386525927189292314135614727777723674556386395638087850174608647747363898930338455891330657389007209468469053124384080820259188661128218030351024937292632"));
		map.put(new Integer(4), new BigInteger("25494204865234849529380955333772727874833182951683399482095745243563202458634709927649447230423532782064330126728678934094569069401481298739070758184571441090194804403740047626372387028558435086273745871321850037292861437577837113184935647545058945443123588426659652334937811761304005940068419934953250030560"));
		map.put(new Integer(5), new BigInteger("68572066009534408854611225046249516859764295612476041379423043509116926735556642163754559825062495461693962703991084647753931163101206013694064450413476799005749906160964999254273980630687904499845534720509287216848944876661354062829390900491497022339485446909979718898375725576097671005862308372567060744762"));
		map.put(new Integer(6), new BigInteger("3129675827863939286874517133602858604445525725196304519967032677128875572647170640462066342071900087611527679635735208026023717537575270182621737038647903371219127624240796341293065300104616726432131761695240639353579056448025146865781213521030675367941551878308768574332305624556049811077819964420711397430"));
		map.put(new Integer(7), new BigInteger("67130832558921143920057040883168067350741760825997087805005366969405754254698998880460175538117974752561466502985358887767118318581282634815464495728391991828028155479888762443653426077798404532552915032501824143155128001715066672786812265392593407031876500122364580655826313280517152242080984737297855052499"));
		map.put(new Integer(8), new BigInteger("80258496773686315098502313341269504935125999815079396520024429341144237850020804434532669067958126917553980699809242150515852173172071998050654173541146901836625831594096636265340731693785764951397749473847745479408808914395745834157817058160497094463982632672132483371712607506294170688873205478869605346885"));
		map.put(new Integer(9), new BigInteger("54209141729167714166615572310319069474127055973989076964474427498992112108900250939160270539888458155101986698955770333080244362973816543128233917063776195423552956319509400752961087465802679130920626295480290085633793411274806522472354135968149579812955823351957491807011622293300521862176333041783203315590"));
		map.put(new Integer(10), new BigInteger("39383361613273873540822257280859202088847036782922792870297297351388779005452081529462397147678707070247381536310417891198008424283310626798173048209835442581777846920426541694194274279896348340763028804744857065881842643182879397168095825192098808929012711659627830975350379568139862013539316500022109683986"));
		map.put(new Integer(11), new BigInteger("77317235097089969664368553351380498206623362203499920355360285249864023421155135338453192362215169743356384982762631932050578734795489982020022208437887945264629974671962708972440497857873214109351669813268078092612524541581755197641067204998885584967893788747355895868471861028979899579778527061612598969060"));
		map.put(new Integer(12), new BigInteger("9805610055047983076632378252772745775273529003787327523276380381990150293499908272458907173942382645726309713838455342529250470045365934803633076198907575126015193770713031026410063040224959580011159202120230259491277519553511186676776941388436023486951849797178317723516433363888227187021132263457704736267"));
		
		int limit = 2;
		long start;
		double time;
		for(int i=2; i<=12; i++) {
			mapTmp.clear();
			for(int j=1; j<=limit; j++) {
				mapTmp.put(new Integer(j), map.get(new Integer(j)));
			}
			start = System.currentTimeMillis();
			Assembly.assembler(mapTmp);
			time = (double)(System.currentTimeMillis()-start)/1000;
			System.out.println(limit+" "+time);
			limit++;
		}
		
	}
	
}