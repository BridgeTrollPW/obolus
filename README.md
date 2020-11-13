# Obolus
An open source XS2A example implementation for various PSD2 compliant standards

## rest
Basic REST interface for communication between a TPP client and ASPSP

## bridge-cbs
Abstraction layer for communication between obolus and the in-place core banking system of the ASPSP. 

An ASPSP can implement this abstraction layer as i/o interface between the already in-place system of the bank and the new obolus system. Here the ASPSP can define from where data is read and how it's transformed into xs2a sepcific structures. This should ease up the integration in an already existing core banking system as the integratio only consists of adding database queries or api calls to the implementing class of the containing interfaces.

## bridge-xs2a
Abstraction layer for standard specific input and output resources at the REST interface.

Obolus