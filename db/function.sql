drop function if exists pro_getChild;
create function pro_getChild(rootId varchar(20))
    returns varchar(3600)
begin
    declare pTemp varchar(3600);
    declare cTemp varchar(2400);
    set pTemp = '';
    set cTemp = rootId;
    WHILE cTemp IS NOT NULL DO
    if pTemp = '' THEN
        set pTemp = concat(pTemp,cTemp);
    else
        set pTemp = concat(pTemp,',',cTemp);
    end if;
    select group_concat(xzqhdm) into cTemp from frm_administrative_division where FIND_IN_SET(sjxzqhdm,cTemp)>0;
    end while;
    return pTemp;
end;