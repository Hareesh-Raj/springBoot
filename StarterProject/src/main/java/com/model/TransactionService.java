package com.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("tss")

public class TransactionService {
	
	@Autowired
	private BankingService bss;
	
	public BankingService getBss() {
		return bss;
	}
	public void setBss(BankingService bss) {
		this.bss = bss;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void moneyTransfer(int crid,int drid,int amt)throws InsufficientBalance {
		bss.doCredit(crid, amt);
		bss.doDebit(drid, amt);			
	}
}