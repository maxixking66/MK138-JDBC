package ir.maktabsharif138.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class JDBCApplication {

    static Map<Integer, Branch> branchMap = new HashMap<>();

    static void main() {

//        Consumer
//        Predicate
//        Function
//        Supplier

//        method reference

        List<AccountInfo> accountList = fetchAccounts();


        accountList.forEach(accountInfo -> {

            accountInfo.branch = computeIfAbsent(
                    accountInfo.branch.id,
//                    id -> getById(id)
                    JDBCApplication::getById
            );

        });

//        fill branch information

        System.out.println(accountList);
    }

    static Branch computeIfAbsent(Integer key, Function<Integer, Branch> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        Branch v;
        if ((v = branchMap.get(key)) == null) {
            Branch newValue;
            if ((newValue = mappingFunction.apply(key)) != null) {
                branchMap.put(key, newValue);
                return newValue;
            }
        }

        return v;
    }

    static Branch getOrDefault(Branch branch, BranchSupplier supplier) {
        if (branch != null) {
            return branch;
        }
        return supplier.get();
    }

    static Branch getById(Integer branchId) {
        System.out.println("invoking very slow api for branch: " + branchId);
        Branch branch = new Branch();
        branch.id = branchId;
        branch.code = branchId + "";
        branch.name = branchId + "";
        return branch;
    }


    private static List<AccountInfo> fetchAccounts() {
        return List.of(
                new AccountInfo(
                        "1",
                        new Branch(1)
                ),
                new AccountInfo(
                        "2",
                        new Branch(2)
                ),
                new AccountInfo(
                        "3",
                        new Branch(1)
                ),
                new AccountInfo(
                        "4",
                        new Branch(4)
                ),
                new AccountInfo(
                        "5",
                        new Branch(2)
                )
        );
    }
}

class AccountInfo {
    String accountNumber;
    Branch branch;

    public AccountInfo(String accountNumber, Branch branch) {
        this.accountNumber = accountNumber;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
               "accountNumber='" + accountNumber + '\'' +
               ", branch=" + branch +
               '}';
    }
}

class Branch {
    Integer id;
    String code;
    String name;

    public Branch() {
    }

    public Branch(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Branch{" +
               "id=" + id +
               ", code='" + code + '\'' +
               ", name='" + name + '\'' +
               '}';
    }
}

class BranchSupplier {
    int branchId;

    BranchSupplier(int branchId) {
        this.branchId = branchId;
    }

    Branch get() {
        System.out.println("invoking very slow api for branch: " + branchId);
        Branch branch = new Branch();
        branch.id = branchId;
        branch.code = branchId + "";
        branch.name = branchId + "";
        return branch;
    }
}