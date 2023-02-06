package org.springframework.samples.petclinic.bill;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Bills {

	private List<Bill> bills;

	@XmlElement
	public List<Bill> getVetList() {
		if (bills == null) {
			bills = new ArrayList<>();
		}
		return bills;
	}

}
