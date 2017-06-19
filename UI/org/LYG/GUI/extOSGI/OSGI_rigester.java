package org.LYG.GUI.extOSGI;
import java.io.IOException;

import org.LYG.GUI.OSGI.*;
import org.LYG.node.ai.WekaPilot2D.WekaPilot2DNodeInterface;
import org.LYG.node.ai.XlsReaderNode.XlsReaderNodeInterface;
import org.LYG.node.ai.arffTransfer.arffTransferNodeInterface;
import org.LYG.node.image.EmbossFilter.EmbossFilterInterface;
import org.LYG.node.image.GrayFilter.GrayFilterNodeInterface;
import org.LYG.node.image.GuassianFilter.GuassianFilterInterface;
import org.LYG.node.image.HoughTransform.HoughTransformInterface;
import org.LYG.node.image.LaplacianFilter.LaplacianFilterInterface;
import org.LYG.node.image.MedianImageFilter.MedianImageNodeInterface;
import org.LYG.node.image.MorphologyFilter.MorphologyFilterInterface;
import org.LYG.node.image.Show3D.Show3DInterface;
import org.LYG.node.image.SobelFilter.SobelFilterNodeInterface;
import org.LYG.node.image.imageRead.imageReadNodeInterface;
import org.LYG.node.image.imageStrech.imageStrechNodeInterface;
import org.LYG.node.movie.AVItoLYG.AVItoLYGNodeInterface;
import org.LYG.node.movie.LYGPlayer.LYGPlayerNodeInterface;
import org.LYG.node.movie.LYGRead.LYGReadNodeInterface;
import org.LYG.node.movie.LYGWrite.LYGWriteNodeInterface;
import org.LYG.node.movie.MovieTransfer.MovieTransferNodeInterface;
import org.LYG.node.sound.ButterworthFilter.ButterworthFilterNodeInterface;
import org.LYG.node.sound.FFT.FFTFilterNodeInterface;
import org.LYG.node.sound.FastICA.FastICANodeInterface;
import org.LYG.node.sound.GuassianWav2DFilter.GuassianWav2DFilterNodeInterface;
import org.LYG.node.sound.HoughWavFilter.HoughWavFilterNodeInterface;
import org.LYG.node.sound.LaplacianFilter.LaplacianFilterNodeInterface;
import org.LYG.node.sound.MaxMiniFilter.MaxMiniFilterNodeInterface;
import org.LYG.node.sound.MedianFilter.MedianFilterNodeInterface;
import org.LYG.node.sound.WavRead.WavReadNodeInterface;
import org.LYG.node.sound.fft2DFilter.ft2DFilterInterface;
import org.LYG.node.sound.freqCount.freqCountNodeInterface;
import org.LYG.node.sound.logFFT.logFFTInterface;
import org.LYG.node.sound.logFFTcount.logFFTcountInterface;
import org.LYG.node.sound.lygFilter.lygFilterNodeInterface;
import org.LYG.node.sound.lygSlaveFilter.lygSlaveFilterInterface;
import org.LYG.node.sound.wavePlay.wavePlayNodeInterface;

public class OSGI_rigester
{
	public OSGI_rigester()
	{
	}
	public nodeOSGI Rigester(nodeOSGI first, linkOSGI link) throws IOException
	{
		//зЂВс
		objectInterface XlsReadernode = new XlsReaderNodeInterface();
		first = link.addNode(first,XlsReadernode);
		//
		objectInterface arffTransferNode = new arffTransferNodeInterface();
		first = link.addNode(first,arffTransferNode);
		
		objectInterface WekaPilot2DNode = new WekaPilot2DNodeInterface();
		first = link.addNode(first,WekaPilot2DNode);
		
		objectInterface imageReadNode = new imageReadNodeInterface();
		first = link.addNode(first,imageReadNode);
		
		objectInterface imageStrechNode = new imageStrechNodeInterface();
		first = link.addNode(first,imageStrechNode);
		
		objectInterface MedianImageNode = new MedianImageNodeInterface();
		first = link.addNode(first,MedianImageNode);
		
		objectInterface GrayFilterNode = new GrayFilterNodeInterface();
		first = link.addNode(first,GrayFilterNode);
		
		
		
		objectInterface GuassianFilterNode = new GuassianFilterInterface();
		first = link.addNode(first,	GuassianFilterNode);
		
		objectInterface SobelFilterNode = new SobelFilterNodeInterface();
		first = link.addNode(first,	SobelFilterNode);
		
		objectInterface EmbossFilterNode = new EmbossFilterInterface();
		first = link.addNode(first,	EmbossFilterNode);
		
		objectInterface LaplacianFilterNode =new LaplacianFilterInterface();
		first = link.addNode(first,	LaplacianFilterNode);
		
		objectInterface HoughTransformNode =new HoughTransformInterface();
		first = link.addNode(first,HoughTransformNode);
		
		objectInterface WavReadNode =new WavReadNodeInterface();
		first = link.addNode(first,WavReadNode);
		
		objectInterface MedianFilterNode  =new MedianFilterNodeInterface();
		first = link.addNode(first,MedianFilterNode);
		
		objectInterface ButterworthFilterNode =new ButterworthFilterNodeInterface();
		first = link.addNode(first,ButterworthFilterNode);

		objectInterface LaplacianWaveFilterNode =new LaplacianFilterNodeInterface();
		first = link.addNode(first,LaplacianWaveFilterNode);
		
		objectInterface HoughWavFilterNode =new HoughWavFilterNodeInterface();
		first = link.addNode(first,HoughWavFilterNode);
		
		objectInterface GuassianWav2DFilterNode =new GuassianWav2DFilterNodeInterface();
		first = link.addNode(first,GuassianWav2DFilterNode);
		
		objectInterface MaxMiniFilterNode =new MaxMiniFilterNodeInterface();
		first = link.addNode(first,MaxMiniFilterNode);
		
		objectInterface wavePlayNode =new wavePlayNodeInterface();
		first = link.addNode(first,wavePlayNode);
		
		objectInterface Show3DNode =new Show3DInterface();
		first = link.addNode(first,Show3DNode);
		
		objectInterface MorphologyFilter =new MorphologyFilterInterface();
		first = link.addNode(first,MorphologyFilter);
		
		
		objectInterface LYGReadNode =new LYGReadNodeInterface();
		first = link.addNode(first,LYGReadNode);
		
		objectInterface LYGWriteNode =new LYGWriteNodeInterface();
		first = link.addNode(first,LYGWriteNode);
		
		objectInterface MovieTransferNode =new MovieTransferNodeInterface();
		first = link.addNode(first,MovieTransferNode);
		
		objectInterface AVItoImagesNode =new AVItoLYGNodeInterface();
		first = link.addNode(first,AVItoImagesNode);
		
		objectInterface LYGPlayerNode =new LYGPlayerNodeInterface();
		first = link.addNode(first,LYGPlayerNode);
		
		objectInterface FFTFilterNode =new FFTFilterNodeInterface();
		first = link.addNode(first,FFTFilterNode);
		
		
		objectInterface freqCountNode =new freqCountNodeInterface();
		first = link.addNode(first,freqCountNode);
	
				
		objectInterface lygFilterNode =new lygFilterNodeInterface();
		first = link.addNode(first,lygFilterNode);
		
		objectInterface lygFilterComp =new ft2DFilterInterface();
		first = link.addNode(first,lygFilterComp);

		objectInterface lygSlave =new lygSlaveFilterInterface();
		first = link.addNode(first,lygSlave);
		
		
		objectInterface logFFT =new logFFTInterface();
		first = link.addNode(first,logFFT);

		objectInterface logFFTcount =new logFFTcountInterface();
		first = link.addNode(first,logFFTcount);

		objectInterface FastICANode =new FastICANodeInterface();
		first = link.addNode(first,FastICANode);
		
		
		return first;	
	}
	
}