<template>
	<div>
		<v-simple-table>
			<template v-slot:default>
				<thead>
					<tr>
						<th class="text-left indigo--text" style="font-size:15px">
							회원명
						</th>
						<th class="text-left indigo--text" style="font-size:15px">
							백신종류
						</th>
						<th class="text-left indigo--text" style="font-size:15px">
							상태
						</th>
						<th class="text-left indigo--text" style="font-size:15px">
							수량
						</th>
						<th class="text-left indigo--text" style="font-size:15px">
							날짜
						</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="item in items" :key="item.name">
						<td>{{ item.userName }}</td>
						<td>{{ item.orderName }}</td>
						<td class="teal--text">{{ item.orderStatus }}</td>
						<td class="red--text">{{ item.orderCount + '개' }}</td>
						<td>{{ `${item.orderDate.slice(0, 10)}` }}</td>
						<v-container class="pa-1">
							<v-btn
								@click="deleteOrder(item.orderId)"
								color="primary"
								class="mt-2"
							>
								취소
							</v-btn>
							<v-btn
								@click="cancelOrder(item.orderId)"
								color="primary"
								v-if="isAdmin"
								class="mt-2"
							>
								대기
							</v-btn>
							<v-btn
								@click="finishOrder(item.orderId)"
								v-if="isAdmin"
								color="primary"
								class="mt-2"
							>
								완료
							</v-btn>
						</v-container>
					</tr>
				</tbody>
			</template>
		</v-simple-table>
	</div>
</template>
<script>
import {
	fetchOrders,
	cancelOrderVaccine,
	deletelOrderVaccine,
	completeOrderVaccine,
} from '@/api/covid';
import bus from '@/utils/bus';
export default {
	data() {
		return {
			items: [],
			oneOrderId: 0,
		};
	},
	computed: {
		isAdmin() {
			return this.$store.state.name == 'admin@naver.com';
		},
	},
	async mounted() {
		const { data } = await fetchOrders();
		this.items = data;
		console.log(data);
		console.log(this.$store.state.orderitem);
	},

	methods: {
		// 예약 취소
		async cancelOrder(orderId) {
			await cancelOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},
		// 예약 삭제
		async deleteOrder(orderId) {
			var con_test = confirm('정말로 취소 하시겠습니까?');
			if (con_test == true) {
				await deletelOrderVaccine(orderId);
				// 데이터 변경사항 적용
				const { data } = await fetchOrders();
				this.items = data;
				bus.$emit('set:quantity');
			} else if (con_test == false) {
				console.log('취소');
			}
		},

		// 접종 완료
		async finishOrder(orderId) {
			await completeOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},
	},
};
</script>
