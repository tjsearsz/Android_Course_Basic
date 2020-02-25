package com.teddysears.BusinessLogic;

/**
 * Interface that represents the command action
 * @param <parameter> The parameter that we need to use in order to execute the commmand
 * @param <response> the response of the execution of the command
 */
public interface ICommand<parameter, response> {

    /**
     * The main execution method
     * @param parameter the parameter we need to use to execute the action
     * @return the answer retrieved
     */
    response execute(parameter parameter);
}
