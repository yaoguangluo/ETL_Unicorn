package org.LYG.GUI.extOSGI;
import java.io.IOException;


import javax.swing.JTextPane;

import org.LYG.GUI.OSGI.*;
//import org.LYG.node.ai.WekaPilot2D.WekaPilot2DNodeInterface;
//import org.LYG.node.ai.XlsReaderNode.XlsReaderNodeInterface;
import org.LYG.node.ai.arffTransfer.arffTransferNodeInterface;
//import org.LYG.node.image.EmbossFilter.EmbossFilterInterface;
//import org.LYG.node.image.FindColorB.FindColorBInterface;
//import org.LYG.node.image.FindColorG.FindColorGInterface;
//import org.LYG.node.image.FindColorR.FindColorRInterface;
//import org.LYG.node.image.GrayFilter.GrayFilterNodeInterface;
//import org.LYG.node.image.GuassianFilter.GuassianFilterInterface;
//import org.LYG.node.image.HoughTransform.HoughTransformInterface;
//import org.LYG.node.image.LaplacianFilter.LaplacianFilterInterface;
//import org.LYG.node.image.MedianImageFilter.MedianImageNodeInterface;
//import org.LYG.node.image.MorphologyFilter.MorphologyFilterInterface;
//import org.LYG.node.image.Show3D.Show3DInterface;
//import org.LYG.node.image.SobelFilter.SobelFilterNodeInterface;
//import org.LYG.node.image.imageRead.imageReadNodeInterface;
//import org.LYG.node.image.imageStrech.imageStrechNodeInterface;
//import org.LYG.node.medcine.ChuFangWuXingShow.ChuFangWuXingShowHInterface;
//import org.LYG.node.medcine.addChuFangAttribute.AddChuFangAttributeHInterface;
//import org.LYG.node.medcine.editPaneReader.EditPanelReaderInterface;
//import org.LYG.node.medcine.editPaneReaderH.EditPanelReaderHInterface;
//import org.LYG.node.medcine.filterChuFangJinJiAttribute.filterChuFangJinJiAttributeHInterface;
//import org.LYG.node.medcine.filterChuFangJinJiKeyWordsAttribute.filterChuFangJinJiKeyWordsAttributeHInterface;
//import org.LYG.node.medcine.filterChuFangXingWeiKeyWordsAttribute.filterChuFangXingWeiKeyWordsAttributeHInterface;
//import org.LYG.node.medcine.updateToEditPane.updateToEditPaneInterface;
//import org.LYG.node.movie.AVItoLYG.AVItoLYGNodeInterface;
//import org.LYG.node.movie.LYGPlayer.LYGPlayerNodeInterface;
//import org.LYG.node.movie.LYGRead.LYGReadNodeInterface;
//import org.LYG.node.movie.LYGWrite.LYGWriteNodeInterface;
//import org.LYG.node.movie.MovieTransfer.MovieTransferNodeInterface;
//import org.LYG.node.sound.ButterworthFilter.ButterworthFilterNodeInterface;
//import org.LYG.node.sound.FFT.FFTFilterNodeInterface;
//import org.LYG.node.sound.GuassianWav2DFilter.GuassianWav2DFilterNodeInterface;
//import org.LYG.node.sound.HoughWavFilter.HoughWavFilterNodeInterface;
//import org.LYG.node.sound.LaplacianFilter.LaplacianFilterNodeInterface;
//import org.LYG.node.sound.MaxMiniFilter.MaxMiniFilterNodeInterface;
//import org.LYG.node.sound.MedianFilter.MedianFilterNodeInterface;
//import org.LYG.node.sound.WavRead.WavReadNodeInterface;
//import org.LYG.node.sound.fft2DFilter.ft2DFilterInterface;
//import org.LYG.node.sound.freqCount.freqCountNodeInterface;
//import org.LYG.node.sound.logFFT.logFFTInterface;
//import org.LYG.node.sound.logFFTcount.logFFTcountInterface;
//import org.LYG.node.sound.lygFilter.lygFilterNodeInterface;
//import org.LYG.node.sound.lygSlaveFilter.lygSlaveFilterInterface;
//import org.LYG.node.sound.wavePlay.wavePlayNodeInterface;

public class OSGI_rigester{
	JTextPane text;
	Object[][] tableData_old;
	public OSGI_rigester(Object[][] tableData_old, JTextPane text){
		this.text= text;
		this.tableData_old= tableData_old;
	}
	public NodeOSGI Rigester(NodeOSGI first, LinkOSGI link) throws IOException{
		//×¢²á
//		ObjectInterface XlsReadernode = new XlsReaderNodeInterface();
//		first = link.addNode(first, XlsReadernode);

		ObjectInterface arffTransferNode = new arffTransferNodeInterface();
		first = link.addNode(first, arffTransferNode);
		
//		ObjectInterface WekaPilot2DNode = new WekaPilot2DNodeInterface();
//		first = link.addNode(first, WekaPilot2DNode);
//		
//		ObjectInterface imageReadNode = new imageReadNodeInterface();
//		first = link.addNode(first, imageReadNode);
//		
//		ObjectInterface imageStrechNode = new imageStrechNodeInterface();
//		first = link.addNode(first, imageStrechNode);
//		
//		ObjectInterface MedianImageNode = new MedianImageNodeInterface();
//		first = link.addNode(first, MedianImageNode);
//		
//		ObjectInterface GrayFilterNode = new GrayFilterNodeInterface();
//		first = link.addNode(first, GrayFilterNode);
//				
//		ObjectInterface GuassianFilterNode = new GuassianFilterInterface();
//		first = link.addNode(first,	GuassianFilterNode);
			
//		ObjectInterface FindColorRNode = new FindColorRInterface();
//		first = link.addNode(first,	FindColorRNode);
//		ObjectInterface FindColorGNode = new FindColorGInterface();
//		first = link.addNode(first,	FindColorGNode);
//		ObjectInterface FindColorBNode = new FindColorBInterface();
//		first = link.addNode(first,	FindColorBNode);
//		
//		ObjectInterface SobelFilterNode = new SobelFilterNodeInterface();
//		first = link.addNode(first,	SobelFilterNode);
//		
//		ObjectInterface EmbossFilterNode = new EmbossFilterInterface();
//		first = link.addNode(first,	EmbossFilterNode);
//		
//		ObjectInterface LaplacianFilterNode = new LaplacianFilterInterface();
//		first = link.addNode(first,	LaplacianFilterNode);
//		
//		ObjectInterface HoughTransformNode = new HoughTransformInterface();
//		first = link.addNode(first,HoughTransformNode);
//		
//		ObjectInterface WavReadNode = new WavReadNodeInterface();
//		first = link.addNode(first,WavReadNode);
//		
//		ObjectInterface MedianFilterNode = new MedianFilterNodeInterface();
//		first = link.addNode(first,MedianFilterNode);
//		
//		ObjectInterface ButterworthFilterNode = new ButterworthFilterNodeInterface();
//		first = link.addNode(first,ButterworthFilterNode);
//
//		ObjectInterface LaplacianWaveFilterNode = new LaplacianFilterNodeInterface();
//		first = link.addNode(first,LaplacianWaveFilterNode);
//		
//		ObjectInterface HoughWavFilterNode = new HoughWavFilterNodeInterface();
//		first = link.addNode(first,HoughWavFilterNode);
//		
//		ObjectInterface GuassianWav2DFilterNode = new GuassianWav2DFilterNodeInterface();
//		first = link.addNode(first,GuassianWav2DFilterNode);
//		
//		ObjectInterface MaxMiniFilterNode = new MaxMiniFilterNodeInterface();
//		first = link.addNode(first,MaxMiniFilterNode);
//		
//		ObjectInterface wavePlayNode = new wavePlayNodeInterface();
//		first = link.addNode(first,wavePlayNode);
//		
//		ObjectInterface Show3DNode = new Show3DInterface();
//		first = link.addNode(first,Show3DNode);
//		
//		ObjectInterface MorphologyFilter = new MorphologyFilterInterface();
//		first = link.addNode(first,MorphologyFilter);
//		
//		ObjectInterface LYGReadNode = new LYGReadNodeInterface();
//		first = link.addNode(first,LYGReadNode);
//		
//		ObjectInterface LYGWriteNode = new LYGWriteNodeInterface();
//		first = link.addNode(first,LYGWriteNode);
//		
//		ObjectInterface MovieTransferNode = new MovieTransferNodeInterface();
//		first = link.addNode(first,MovieTransferNode);
//		
//		ObjectInterface AVItoImagesNode = new AVItoLYGNodeInterface();
//		first = link.addNode(first,AVItoImagesNode);
//		
//		ObjectInterface LYGPlayerNode = new LYGPlayerNodeInterface();
//		first = link.addNode(first,LYGPlayerNode);
//		
//		ObjectInterface FFTFilterNode = new FFTFilterNodeInterface();
//		first = link.addNode(first,FFTFilterNode);
//		
//		ObjectInterface freqCountNode = new freqCountNodeInterface();
//		first = link.addNode(first,freqCountNode);
//			
//		ObjectInterface lygFilterNode = new lygFilterNodeInterface();
//		first = link.addNode(first,lygFilterNode);
//		
//		ObjectInterface lygFilterComp = new ft2DFilterInterface();
//		first = link.addNode(first,lygFilterComp);
//
//		ObjectInterface lygSlave = new lygSlaveFilterInterface();
//		first = link.addNode(first,lygSlave);
//		
//		ObjectInterface logFFT = new logFFTInterface();
//		first = link.addNode(first,logFFT);
//
//		ObjectInterface logFFTcount = new logFFTcountInterface();
//		first = link.addNode(first,logFFTcount);
//
//		ObjectInterface editPanelReader = new EditPanelReaderInterface(this.text);
//		first = link.addNode(first,editPanelReader);
//		
//		ObjectInterface editPanelReaderH = new EditPanelReaderHInterface(this.text);
//		first = link.addNode(first,editPanelReaderH); 	
//		
//		ObjectInterface addChuFangAttributeH = new AddChuFangAttributeHInterface(this.tableData_old
//				, this.text);
//		first = link.addNode(first,addChuFangAttributeH); 
//		
//		ObjectInterface filterChuFangJinJiAttributeH = 
//				new filterChuFangJinJiAttributeHInterface(this.tableData_old, this.text);
//		first = link.addNode(first,filterChuFangJinJiAttributeH); 
//		
//		ObjectInterface chuFangWuXingShowHInterface = 
//				new ChuFangWuXingShowHInterface(this.tableData_old, this.text);
//		first = link.addNode(first,chuFangWuXingShowHInterface); 
//		//É¨Ãèjar¡¢¡¢Ìí¼Ójar
//		ObjectInterface filterChuFangXingWeiKeyWordsAttributeH = 
//				new filterChuFangXingWeiKeyWordsAttributeHInterface(this.tableData_old, this.text);
//		first = link.addNode(first,filterChuFangXingWeiKeyWordsAttributeH); 
//		
//		ObjectInterface filterChuFangJinJiKeyWordsAttributeH = 
//				new filterChuFangJinJiKeyWordsAttributeHInterface(this.tableData_old, this.text);
//		first = link.addNode(first,filterChuFangJinJiKeyWordsAttributeH); 
//		
//		
//		ObjectInterface updateToEditPane = 
//				new updateToEditPaneInterface(this.tableData_old, this.text);
//		first = link.addNode(first, updateToEditPane); 

		return first;	
	}

}