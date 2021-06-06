package com.har.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CallerTune implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5124580499055872897L;
	private Integer callerTuneId;
	private String callerTune;
	private String provider;
	private Long mobile;
	//private Date lastUpdated;
	private Timestamp lastUpdated; //For object auditing  we can use <timestamp> in <CallerTune.hbm.xml>
		
}
