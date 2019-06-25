/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project19;

/**
 *
 * @author admin
 */
public class Emergency {

    private String idx;
    private String addr;
    private String name;
    private String tel1;
    private String tel2;

    public Emergency(String Idx, String Addr, String Name, String Tel1, String Tel2) {
        this.idx = Idx;
        this.addr = Addr;
        this.name = Name;
        this.tel1 = Tel1;
        this.tel2 = Tel2;

    }

    public String getIdx() {
        return idx;

    }

    public String getAddr() {
        return addr;

    }

    public String getName() {
        return name;

    }

    public String getTel1() {
        return tel1;

    }

    public String getTel2() {
        return tel2;

    }

}
