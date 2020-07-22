Feature: Test the Deflation Compression algorithm

  Scenario: Test inflating data
    Given deflation bytes:
    """
    120,-100,-99,-109,-51,74,-61,64,16,-128,-17,-127,-68,-61,30,83,80,-102,-97,-74,73,122,-85,18,68,-63,82,106,-117,7,-15,-112,-38,81,23,54,-69,101,119,43,22,-15,-55,60,-8,72,-66,-126,105,18,113,119,108,106,-23,37,-20,-26,-101,-7,118,118,50,-7,-6,-8,-68,-103,77,47,-57,23,36,112,-99,55,-41,-103,-80,124,3,114,-69,121,119,29,-41,105,88,-28,58,-35,46,-103,115,-86,-43,-112,60,-5,126,64,-68,-23,-102,115,-112,-99,19,50,-50,11,32,-34,-10,-39,-87,12,53,-80,-13,123,123,-14,39,82,-84,64,-14,50,95,17,-81,-34,84,78,-43,-82,-21,87,-28,106,-51,-97,24,-112,76,61,-28,43,-80,3,6,85,-64,-120,111,-20,-41,-79,121,-59,-48,102,-119,-55,34,-101,-91,38,-21,-39,44,-16,77,-40,71,-48,106,-22,0,-63,-48,-124,49,-126,-111,9,19,4,123,38,76,17,-84,-69,-109,113,40,40,40,-60,-22,-58,-100,9,-91,-2,-96,-70,57,117,55,37,-122,9,-6,-128,33,-15,110,5,123,36,119,-63,-3,-114,17,-8,65,72,-110,-18,-107,28,49,7,-95,-113,-116,126,99,-52,-72,-106,27,50,22,75,104,-85,-18,55,2,41,-125,67,-108,-57,-44,26,34,113,-44,-120,-81,-59,11,20,-64,-11,-34,114,-83,32,36,-58,63,103,-101,-8,-104,-94,-29,-54,61,90,80,70,117,57,77,67,50,-86,58,114,46,24,-93,-118,10,78,-30,-2,-114,-110,77,-116,-124,-55,65,-62,25,93,17,111,38,4,-45,-27,-30,-76,-68,-128,44,114,-10,-81,59,61,-56,61,95,-128,-44,-69,-4,-27,34,123,-43,-64,-105,-80,108,61,-22,27,-27,43,96,-14
    """
    When data is inflated with size 1327
    Then inflated data should be:
    """
    -17,-69,-65,83,84,82,73,78,71,32,49,13,10,123,13,10,80,108,97,121,101,114,32,49,13,10,125,13,10,13,10,83,84,82,73,78,71,32,51,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,49,32,40,82,117,110,110,101,114,41,44,32,78,97,109,101,32,40,78,97,109,101,41,13,10,123,13,10,82,117,110,110,101,114,13,10,125,13,10,13,10,83,84,82,73,78,71,32,52,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,49,32,40,82,117,110,110,101,114,41,44,32,80,114,111,112,101,114,110,97,109,101,115,32,40,80,114,111,112,101,114,32,78,97,109,101,115,41,13,10,123,13,10,82,117,110,110,101,114,13,10,125,13,10,13,10,83,84,82,73,78,71,32,53,13,10,123,13,10,74,117,110,103,108,101,32,69,115,99,97,112,101,13,10,125,13,10,13,10,83,84,82,73,78,71,32,54,13,10,123,13,10,65,110,121,13,10,125,13,10,13,10,83,84,82,73,78,71,32,55,13,10,123,13,10,80,108,97,121,101,114,32,50,13,10,125,13,10,13,10,83,84,82,73,78,71,32,56,13,10,123,13,10,80,108,97,121,101,114,32,51,13,10,125,13,10,13,10,83,84,82,73,78,71,32,57,13,10,123,13,10,80,108,97,121,101,114,32,52,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,48,13,10,123,13,10,80,108,97,121,101,114,32,53,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,49,13,10,123,13,10,80,108,97,121,101,114,32,54,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,50,13,10,123,13,10,80,108,97,121,101,114,32,55,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,51,13,10,123,13,10,80,108,97,121,101,114,32,56,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,52,13,10,123,13,10,80,108,97,121,101,114,32,57,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,53,13,10,123,13,10,69,110,101,109,105,101,115,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,54,13,10,123,13,10,66,111,115,115,101,115,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,55,13,10,123,13,10,69,115,99,97,112,101,114,115,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,56,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,50,32,40,87,111,108,102,32,91,49,93,41,44,32,78,97,109,101,32,40,78,97,109,101,41,13,10,123,13,10,87,111,108,102,32,91,49,93,13,10,125,13,10,13,10,83,84,82,73,78,71,32,49,57,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,50,32,40,87,111,108,102,32,91,49,93,41,44,32,80,114,111,112,101,114,110,97,109,101,115,32,40,80,114,111,112,101,114,32,78,97,109,101,115,41,13,10,123,13,10,82,117,110,110,101,114,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,48,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,48,32,40,87,111,108,102,32,69,110,116,114,121,32,78,111,100,101,41,44,32,78,97,109,101,32,40,78,97,109,101,41,13,10,123,13,10,87,111,108,102,32,69,110,116,114,121,32,78,111,100,101,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,49,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,48,32,40,87,111,108,102,32,69,110,116,114,121,32,78,111,100,101,41,44,32,80,114,111,112,101,114,110,97,109,101,115,32,40,80,114,111,112,101,114,32,78,97,109,101,115,41,13,10,123,13,10,82,117,110,110,101,114,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,50,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,51,32,40,87,111,108,102,32,77,111,118,101,109,101,110,116,32,78,111,100,101,41,44,32,78,97,109,101,32,40,78,97,109,101,41,13,10,123,13,10,87,111,108,102,32,77,111,118,101,109,101,110,116,32,78,111,100,101,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,51,13,10,47,47,32,85,110,105,116,115,58,32,104,48,48,51,32,40,87,111,108,102,32,77,111,118,101,109,101,110,116,32,78,111,100,101,41,44,32,80,114,111,112,101,114,110,97,109,101,115,32,40,80,114,111,112,101,114,32,78,97,109,101,115,41,13,10,123,13,10,82,117,110,110,101,114,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,55,13,10,47,47,32,65,98,105,108,105,116,105,101,115,58,32,65,48,48,48,32,40,67,111,108,108,105,115,105,111,110,32,55,53,41,44,32,78,97,109,101,32,40,78,97,109,101,41,13,10,123,13,10,67,111,108,108,105,115,105,111,110,32,55,53,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,56,13,10,47,47,32,65,98,105,108,105,116,105,101,115,58,32,65,48,48,48,32,40,67,111,108,108,105,115,105,111,110,32,55,53,41,44,32,84,105,112,32,40,84,111,111,108,116,105,112,32,45,32,78,111,114,109,97,108,41,13,10,123,13,10,67,111,108,108,105,115,105,111,110,32,55,53,13,10,125,13,10,13,10,83,84,82,73,78,71,32,50,57,13,10,47,47,32,65,98,105,108,105,116,105,101,115,58,32,65,48,48,48,32,40,67,111,108,108,105,115,105,111,110,32,55,53,41,44,32,85,98,101,114,116,105,112,32,40,84,111,111,108,116,105,112,32,45,32,78,111,114,109,97,108,32,45,32,69,120,116,101,110,100,101,100,41,13,10,123,13,10,67,111,108,108,105,115,105,111,110,32,55,53,13,10,125,13,10,13,10
    """