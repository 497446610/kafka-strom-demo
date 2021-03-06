/*
 * @(#)SentenceSpout.java        1.0 2018年3月14日
 *
 *
 */

package cn.kuangxf.example.word.spout;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

/**
 * Class description goes here.
 *
 * @version 	1.0 2018年3月14日
 * @author		Administrator
 * @history	
 *		
 */
public class SentenceSpout extends BaseRichSpout {

	 private SpoutOutputCollector collector;  
	    private String[] sentences = {  
	            "Apache Storm is a free and open source distributed realtime computation system",  
	            "Storm makes it easy to reliably process unbounded streams of data",  
	            "doing for realtime processing what Hadoop did for batch processing",  
	            "Storm is simple", "can be used with any programming language",  
	            "and is a lot of fun to use" };  
	    private int index = 0;  
	  
	    @Override  
	    public void declareOutputFields(OutputFieldsDeclarer declarer) {  
	        //定义输出字段描述  
	        declarer.declare(new Fields("sentence"));  
	    }  
	  
	    @SuppressWarnings("rawtypes")  
	    public void open(Map config, TopologyContext context,SpoutOutputCollector collector) {  
	        this.collector = collector;  
	    }  
	    
	      
	    public void nextTuple() {  
	         if(index >= sentences.length){  
	            return;   
	         }  
	         //发送字符串  
	        this.collector.emit(new Values(sentences[index]));  
	        index++;  
	        Utils.sleep(1);  
	    }  


}
