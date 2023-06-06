package com.fnb.rofa.co.za.adapter;

import com.fnb.rofa.co.za.dto.InvoiceDTO;
import com.fnb.rofa.co.za.model.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceAdapterBean implements InvoiceAdpater{
    @Override
    public Invoice createInvoice(InvoiceDTO invoiceDTO) {
        return null;
    }
}
