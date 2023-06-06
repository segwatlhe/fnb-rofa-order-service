package com.fnb.rofa.co.za.adapter;

import com.fnb.rofa.co.za.dto.InvoiceDTO;
import com.fnb.rofa.co.za.model.Invoice;

public interface InvoiceAdpater {

    Invoice createInvoice(InvoiceDTO invoiceDTO);
}
