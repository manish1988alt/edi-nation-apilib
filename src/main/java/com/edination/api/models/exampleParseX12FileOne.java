/*
   Copyright [2011] [Prasad Balan]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.edination.api.models;



import com.edination.api.Dao.EDI271Repository;
import com.edination.api.Dao.EDI271Service;
import com.edination.api.eligibility.EDIFile.Segment;
import com.edination.api.eligibility.model.EdiDataElement271;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Example showing X12 Parser reading a X12 file and looping over the segments.
 * 
 * @author Prasad Balan
 * 
 * <pre>
 * Example of parsing a X12 file
 * 
 * This is the loop hierarchy of a 835 transaction used here.
 *  
 * +--X12
 * |  +--ISA - ISA
 * |  |  +--GS - GS
 * |  |  |  +--ST - ST - 835, - 1
 * |  |  |  |  +--1000A - N1 - PR, - 1
 * |  |  |  |  +--1000B - N1 - PE, - 1
 * |  |  |  |  +--2000 - LX
 * |  |  |  |  |  +--2100 - CLP
 * |  |  |  |  |  |  +--2110 - SVC
 * |  |  |  +--SE - SE
 * |  |  +--GE - GE
 * |  +--IEA - IEA
 * 
 * Cf cf835 = loadCf();
 * Parser parser = new X12Parser(cf835);
 * // The configuration Cf can be loaded using DI framework.
 * // Check the sample spring application context file provided.
 *    
 * Double totalChargeAmount = 0.0;
 * X12 x12 = (X12) parser.parse(new File(&quot;C:\\test\\835.txt&quot;));
 * List&lt;Segment&gt; segments = x12.findSegment(&quot;CLP&quot;);
 * for (Segment s : segments) {
 *     totalChargeAmount = totalChargeAmount + Double.parseDouble(s.getElement(3));
 * }
 * System.out.println(&quot;Total Change Amount &quot; + s.getElement(3));
 * 
 * </pre>
 * 
 * <pre>
 * Example of how to create a configuration object for the above hierarchy
 * 
 * private static Cf loadCf() {
 * 	Cf cfX12 = new Cf(&quot;X12&quot;);
 * 	Cf cfISA = cfX12.addChild(&quot;ISA&quot;, &quot;ISA&quot;);
 * 	Cf cfGS = cfISA.addChild(&quot;GS&quot;, &quot;GS&quot;);
 * 	Cf cfST = cfGS.addChild(&quot;ST&quot;, &quot;ST&quot;, &quot;835&quot;, 1);
 * 	cfST.addChild(&quot;1000A&quot;, &quot;N1&quot;, &quot;PR&quot;, 1);
 * 	cfST.addChild(&quot;1000B&quot;, &quot;N1&quot;, &quot;PE&quot;, 1);
 * 	Cf cf2000 = cfST.addChild(&quot;2000&quot;, &quot;LX&quot;);
 * 	Cf cf2100 = cf2000.addChild(&quot;2100&quot;, &quot;CLP&quot;);
 * 	cf2100.addChild(&quot;2110&quot;, &quot;SVC&quot;);
 * 	cfISA.addChild(&quot;GE&quot;, &quot;GE&quot;);
 * 	cfX12.addChild(&quot;IEA&quot;, &quot;IEA&quot;);
 * 	//System.out.println(cfX12);
 * 	return cfX12;
 * }
 * </pre>
 * 
 */
public class exampleParseX12FileOne {
	@Autowired
	EDI271Service edi271Repository;
	EdiDataElement271	ediDataElement272=new EdiDataElement271();
	public EdiDataElement271 insertOpertion271(File f1, EdiDataElement271 ediDataElement271,String mrnNumber) {
		X12 x12 = null;
		Cf cf835 = loadCf(); // candidate for dependency injection
		Parser parser = new X12Parser(cf835);
		Boolean Confirm=false;
	/*	Double totalChargeAmount = 0.0;

		URL url = exampleParseX12FileOne.class.getClass().getResource("/Hipaa-5010-271-GenericResponse.txt");
		File f1 = new File(url.getFile());*/
        List<String> list=new ArrayList<>();
		try {
			x12 = (X12) parser.parse(f1);

			List<Segment> segments = x12.findSegment("NM1");
           List<String> NM1=new ArrayList<>();
			for (Segment s : segments) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					NM1.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> HLSeg = x12.findSegment("HL");
			List<String> HL=new ArrayList<>();
			for (Segment s : HLSeg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					HL.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> TRNSeg = x12.findSegment("TRN");
			List<String> TRN=new ArrayList<>();
			for (Segment s : TRNSeg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					TRN.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> N3Seg = x12.findSegment("N3");
			List<String> N3=new ArrayList<>();
			for (Segment s : N3Seg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					N3.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> N4Seg = x12.findSegment("N4");
			List<String> N4=new ArrayList<>();
			for (Segment s : N4Seg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					N4.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> DMGSeg = x12.findSegment("DMG");
			List<String> DMG=new ArrayList<>();
			for (Segment s : DMGSeg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					DMG.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> DTPSeg = x12.findSegment("DTP");
			List<String> DTP=new ArrayList<>();
			for (Segment s : DTPSeg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					DTP.add(s.getElement(i));
					Confirm=true;
				}
			}

			List<Segment> EBSeg = x12.findSegment("EB");
			List<String> EB=new ArrayList<>();
			for (Segment s : EBSeg) {
				System.out.println("insiide seg");
				for(int i=0;i<s.size();i++)
				{
					EB.add(s.getElement(i));
					Confirm=true;
				}
			}
			String NMS1="";
			String NMS2="";
			String NMS3="";
			String NMS4="";
			String NMS5="";
			String NMS6="";
			String NMS7="";
			String NMS8="";
			String NMS9="";
			for(int i=0;i<NM1.size();i++)
			{
				//System.out.println(i+"NM: "+NM1.get(i));
                 NMS1=NM1.get(29).trim();
                 NMS2=NM1.get(24).trim();
                 NMS3=NM1.get(23).trim();
                 NMS9=NM1.get(26).trim();
                 NMS4=NM1.get(22).trim();
                 NMS5=NM1.get(28).trim();
                 NMS6=NM1.get(11).trim();
                 NMS7=NM1.get(13).trim();
                 NMS8=NM1.get(29).trim();

			}
System.out.println("NMS1:"+NMS1+" NMS2:"+NMS2+" NMS3:"+NMS3+" NMS4: "+NMS4+" NMS5:"+NMS5+" NMS6:"+NMS6+" NMS7:"+NMS7+" NMS8:"+NMS8);



			for(int i=0;i<HL.size();i++)
			{
				//System.out.println(i+"HL: "+HL.get(i));
			}
			String TRNS1="";
			String TRNS2="";
			for(int i=0;i<TRN.size();i++)
			{
				//System.out.println(i+"TRN: "+TRN.get(i));
				TRNS1=TRN.get(1);
				TRNS2=TRN.get(2);

			}
			System.out.println("TRNS1:"+TRNS1+" TRNS2:"+TRNS2);

			String N3S1="";
			String N3S2="";
			for(int i=0;i<N3.size();i++)
			{
				//System.out.println(i+"N3: "+N3.get(i));
				N3S1=N3.get(1)+" "+N3.get(2);
				N3S2=N3.get(1)+" "+N3.get(2);
			}
			System.out.println("N3S1:"+N3S1+" N3S2:"+N3S2);

			String N4S1="";
			String N4S2="";
			String N4S3="";
			String N4S4="";
			String N4S5="";
			String N4S6="";
			for(int i=0;i<N4.size();i++)
			{
				//System.out.println(i+"N4: "+N4.get(i));
				N4S1=N4.get(3);
				N4S2=N4.get(1);
				N4S3=N4.get(2);
				N4S4=N4.get(2);
				N4S5=N4.get(3);
				N4S6=N4.get(1);
			}
			System.out.println("N4S1:"+N4S1+" N4S2:"+N4S2+" N4S3:"+N4S3+" N4S4:"+N4S4+" N4S5:"+N4S5+" N4S6:"+N4S6);
			String DMGS1="";
			for(int i=0;i<DMG.size();i++)
			{
				//System.out.println(i+"DMG: "+DMG.get(i));
				DMGS1=DMG.get(2);
			}
			System.out.println("DMGS1:"+DMGS1);
			String DTPS1="";
			String DTPS2="";
			for(int i=0;i<DTP.size();i++)
			{
				//System.out.println(i+"DTP: "+DTP.get(i));
				DTPS1=DTP.get(1);
				DTPS2=DTP.get(3);
			}
			System.out.println("DTPS1:"+DTPS1+" DTPS2:"+DTPS2);
			String EBS1=" ";
			String EBS2=" ";
			String EBS3=" ";
			String EBS4=" ";
			String EBS5=" ";
			String EBS6=" ";
			String EBS7=" ";
			String EBS8=" ";
			for(int i=0;i<EB.size();i++)
			{
				//System.out.println(i+"EB: "+EB.get(i));
				if(EB.get(1).equals("1"))
				{
					EBS1="Eligible";
				}
				else
				{
					EBS1="Not Eligible";
				}

				EBS2=EB.get(16);
				if(("").equals(EB.get(4)))
				{
					EBS3="EMPTY";
				}
				else
				{
					EBS3=EB.get(4);
				}
				EBS4=EB.get(32);
				EBS5=EB.get(3);
				EBS6=EB.get(18);
				//EBS7=EB.get(22);
				if(("").equals(EB.get(22)))
				{
					EBS7="EMPTY";
				}
				else
				{
					EBS7=EB.get(22);
				}
			}
			System.out.println("EBS1:"+EBS1+" EBS2:"+EBS2+" EBS3:"+EBS3+" EBS4:"+EBS4+" EBS5:"+EBS5+" EBS6:"+EBS6+" EBS7:"+EBS7);
				ediDataElement272=new EdiDataElement271(NMS1, TRNS1, NMS3,NMS2,NMS9, DMGS1,NMS1,N3S2,N4S2, N4S3,N4S1,DTPS1,DTPS2,EBS1,EBS5, EBS2,EBS6,EBS4,EBS7,EBS3,NMS8,"EMPTY", "EMPTY","EMPTY", "EMPTY",NMS5,N3S1,NMS1,NMS4, NMS7,N3S1,N4S2,N4S3,N4S5,mrnNumber);




		} catch (Exception e1) {
			Confirm=false;
			e1.printStackTrace();
		}
		//edi271Repository.save(ediDataElement272);
		return ediDataElement272;
	}

	// Alternately can be loaded using Spring/DI 
	private static Cf loadCf() {
		/*Cf cfX12 = new Cf("X12");
		Cf cfISA = cfX12.addChild("ISA", "ISA");
		Cf cfGS = cfISA.addChild("GS", "GS");
		Cf cfST = cfGS.addChild("ST", "ST", "271", 1);
		cfST.addChild("1000A", "NM1", "PR", 2);
		cfST.addChild("1000B", "NM1", "1P", 2);
		Cf cf2000 = cfST.addChild("2000", "HL");
		Cf cf2100 = cf2000.addChild("2100", "NM1");
		cf2100.addChild("2110", "EB");
		cfISA.addChild("GE", "GE");
		cfX12.addChild("IEA", "IEA");
		//System.out.println(cfX12);
		return cfX12;*/

		Cf cfX12 = new Cf("X12");
		Cf cfISA = cfX12.addChild("ISA", "ISA");
		Cf cfGS = cfISA.addChild("GS", "GS");
		Cf cfST = cfGS.addChild("ST", "ST", "271", 1);
		cfST.addChild("2100A", "NM1", "PR", 2);
		cfST.addChild("2100B", "NM1", "1P", 2);
		Cf cf2000 = cfST.addChild("2000", "HL");
		Cf cf2100A = cf2000.addChild("2100A", "TRN");
		Cf cf2100 = cf2100A.addChild("2100", "NM1");
		Cf cf2100B = cf2100.addChild("2100B", "N3");
		Cf cf2100C = cf2100B.addChild("2100C", "N4");
		Cf cf2100D = cf2100C.addChild("2100D", "DMG");
		Cf cf2100E = cf2100D.addChild("2100E", "DTP");
		Cf cf2110=cf2100E.addChild("2110", "EB");
		Cf cf2120= cf2110.addChild("2120","NM1");
		cfISA.addChild("GE", "GE");
		cfX12.addChild("IEA", "IEA");
		return cfX12;
	}
}
