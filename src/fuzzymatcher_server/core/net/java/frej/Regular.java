/*
Copyright 2011 Rodion Gorkovenko

This file is a part of FREJ
(project FREJ - Fuzzy Regular Expressions for Java - http://frej.sf.net)

FREJ is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

FREJ is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with FREJ.  If not, see <http://www.gnu.org/licenses/>.
*/

package fuzzymatcher_server.core.net.java.frej;


class Regular extends Elem {

    
    private String pattern;
    
    
    Regular(Regex owner, String pattern) {
        super(owner);
        this.pattern = pattern;
    } // Regular
    
    
    @Override
    ResultSet matchAt(int i) {
        matchStart = i;
        matchLen = 0;
        
        if (i >= owner.tokens.length || !owner.tokens[i].matches(pattern)) {
            return ResultSet.empty;
        } // if
        
        matchLen = 1;
        
        saveGroup();
        
        return super.matchAt(i);
    } // matchAt
    
    
    @Override
    public String toString() {
        return "(!" + pattern + ")" + super.toString();
    } // toString
    
    
} // Regular
