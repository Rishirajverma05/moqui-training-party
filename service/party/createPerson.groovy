def party = ec.entity.find("party.Party").condition("partyId",partyId).one()
if(party == null){
    ec.message("${partyId} does not exist")
    return
}
if(party.partyTypeEnumId != "PERSON"){
    ec.message("${partyId} Is not PERSON type" )
    return
}
ec.entity.makeValue("party.Person").setAll(context).create()
context.responseMessage ="Person ${firstName} ${lastName} created successfully!"