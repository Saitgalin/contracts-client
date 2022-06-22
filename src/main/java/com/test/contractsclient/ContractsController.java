package com.test.contractsclient;

import java.io.IOException;

public interface ContractsController {
    Contract[] getContracts() throws IOException, InterruptedException;
}
