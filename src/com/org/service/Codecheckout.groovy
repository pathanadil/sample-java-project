package com.org.service

//import groovy.transform.Field
//import com.toyota.tfs.exception.*
import com.toyota.tfs.log.Logger
import com.toyota.tfs.log.LogLevel


public class Codecheckout implements Serializable{
Script mainScript
Map specs
Logger logger

  def Codecheckout(Script mainScript, Map specs){
  this.mainScript = mainScript
  this.specs = specs
  this.logger = new Logger(mainScript,"Codecheckout")
  }
  def checkOutFunc(Map specs){
    try {
      mainScript.checkout([$class: 'GitSCM',
      branches: [[name: specs.branch]],
      extensions: [],
      userRemoteConfigs: [[url: specs.repo ]]
      ])
      logger.info "Code succesfully checkedout from: " + specs.branch
    } catch(Exception e){
            throw new Exception("Error in Codecheckout: " + e.getMessage())
        }
  } 
  

