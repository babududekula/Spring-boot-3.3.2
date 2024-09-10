package com.pack.binding;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@XmlAccessorOrder
@AllArgsConstructor
@NoArgsConstructor
public class Event 
{
	private Integer eventId;
	private String eventName;
	private String eventType;
	private Double eventAmount;
}
